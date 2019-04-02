package com.salmon.controller;

import com.salmon.Services.*;
import com.salmon.TO.Annotation;
import com.salmon.TO.OtherData;
import com.salmon.TO.PdfCore;
import com.salmon.TO.PdfCoreCollection;
import com.salmon.util.AES;
import dkproparent.DKProparent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.Naming;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
@RequestMapping(value = "/action")
public class DynamicAnalyzerAgent {

    @Autowired
    PDFCoreService pdfCoreService;
    @Autowired
    AnnotationService annotationService;
    @Autowired
    OtherDataService otherDataService;

    @Autowired
    CollectionService collectionService;

    @Autowired
    RelevantHandlerService relevantHandlerService;

    /**
     * RMI connection to server , this is client
     * Send tags to front
     **/


    @RequestMapping(value = "/tag")
    @ResponseBody
    public String action(@RequestBody String json, HttpServletResponse response) {

        try {
            JSONObject jsonObject = new JSONObject(json);
            String pdfLink = jsonObject.getString("pdfCore");
            String isPdfCore = pdfCoreService.getPdfCore(pdfLink);
            // send title from backend driect // we didnt get title
            if (!isPdfCore.equals("false")) {
                response.setStatus(201); //===> Update.do
                System.out.println("MetaData Json" + isPdfCore);
                /**
                 *     it means that PdfCore link exist in database
                 */
                return isPdfCore;
            } else {

                //RMI connection to server so this is client

                DKProparent dkProparent = (DKProparent) Naming.lookup("//localhost/dkproparent");
                String tags = dkProparent.getText(pdfLink);

                JSONObject content = new JSONObject(tags);
                String hash = content.getString("hashkey");
                String tagExist = pdfCoreService.getPdfTags(hash);


                if (tagExist.equals("false")) {


                    /**
                     *     this is new Pdfcore Hashkey
                     */

                    response.setStatus(200);
                    return content.toString(); // From calias
                } else {
                    /**
                     *     Existance hashkey
                     */
                    response.setStatus(302);//that was existed from database ===> Update .do
                    System.out.println(tagExist);
                    return tagExist;
                }

            }
        } catch (Exception e) {
            response.setStatus(503);
            return null;
        }

    }


    @RequestMapping(value = "/initialTags")
    public void RegisterPdfCore(@RequestBody String json, HttpServletResponse response) {
        try {
            JSONObject jsonObject = new JSONObject(json.toString());
            String pdfLink = jsonObject.getString("pdfCoreLink");
            System.out.println(jsonObject);
            boolean relevant = true;
            try {
                relevant = jsonObject.getJSONObject("relevantData").getBoolean("relevant");
            } catch (JSONException e) {
            }

            if (!relevant) {

                long id = jsonObject.getJSONObject("relevantData").getLong("id");
                String semanticTags = jsonObject.getJSONObject("relevantData").getString("semanticTags");
                String text = jsonObject.getJSONObject("relevantData").getString("text");
                String title = jsonObject.getJSONObject("relevantData").getString("title");
                String url = jsonObject.getJSONObject("relevantData").getString("pdfCore");

                relevantHandlerService.isNotRelevant(id, text, semanticTags, title, url);


            } else {
                String isPdfCore = pdfCoreService.getPdfCore(pdfLink);

                if (!isPdfCore.equals("false")) {
                    response.setStatus(201);

                } else {


                    //String pdfCoreLink = jsonObject.getString("pdfCoreLink");
                    PdfCore pdfCore = new PdfCore();
                    //for iteration begin
                    String tag = " ";
                    try {

                        for (int i = 1; i < 15; i++) {
                            tag += jsonObject.getString("tag" + i) + ",";

                        }


                    } catch (JSONException e) {
                        System.out.println("tags end");
                    }
                    //for iteration end
                    String hashKey = jsonObject.getString("hashKey");
                    String username = jsonObject.getString("username");
                    //set DateAndTime for tags registration
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String date = dateTimeFormatter.format(now);
                    pdfCore.setDate(date);

                    pdfCore.setUniqueHash(hashKey);
                    pdfCore.setUsername(username);
                    pdfCore.setPdfCore(pdfLink);
                    pdfCore.setTags(tag);

                    pdfCoreService.register(pdfCore);

                    collectionService.collection(jsonObject.getString("txt"), tag, jsonObject.getString("tag3"), pdfLink);


                    response.setStatus(200);
                }
            }
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
            System.out.println("Registering pdfCore json has an EXCEPTION");
            response.setStatus(502);
        }
    }

    @RequestMapping(value = "updateTags")
    public void updateTag(@RequestBody String json, HttpServletResponse response) {
        try {


            JSONObject jsonObject = new JSONObject(json.toString());
            String pdfCore = jsonObject.getString("pdfCore");

            int i;
            String tags = " ";

            try {


                for (i = 1; i < 15; i++) {
                    tags += jsonObject.getString("tag" + i) + ",";
                }
            } catch (JSONException e) {
            }

            pdfCoreService.pdfUpdate(pdfCore, tags);
            response.setStatus(200);


        } catch (Exception e) {
            response.setStatus(501);
        }

    }

    @RequestMapping(value = "/relevantCard")
    @ResponseBody
    public String relevant(@RequestBody String json) {
        try {

            JSONObject jsonObject = new JSONObject(json);
            int score = jsonObject.getInt("relevant");
            int id = jsonObject.getInt("id");
            String relevant = relevantHandlerService.scoreRate(score, id);
            // System.out.println(relevant);
            return relevant;

        } catch (JSONException e) {
            return null;
        }
    }


    @RequestMapping(value = "otherData")

    public void RegisterOtherData(HttpServletRequest request) {

        String linkAddr = request.getParameter("externallink");
        String pin = request.getParameter("pin");

        OtherData otherData = new OtherData();
        otherData.setUsername(request.getParameter("username"));
        if (!pin.equals(" ")) otherData.setPin(Boolean.parseBoolean(pin));
        if (!request.getParameter("like").equals(" ")) otherData.setLike(otherDataService.setLikes(linkAddr));
        if (!request.getParameter("dislike").equals(" ")) otherData.setDislike(otherDataService.setDislike(linkAddr));
        otherData.setLinkAddress(linkAddr);
        otherDataService.register(otherData);


    }

    @RequestMapping(value = "getOtherData")
    @ResponseBody
    public String getOtherData() {

        try {
            List<OtherData> otherDataList = otherDataService.getAll(OtherData.class);

            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for (OtherData otherData : otherDataList) {

                jsonObject.put("username", otherData.getUsername());
                jsonObject.put("externalLinks", otherData.getLinkAddress());
                jsonObject.put("likes", otherData.getLike());
                jsonObject.put("dislikes", otherData.getDislike());
                jsonObject.put("pin", otherData.isPin());
                jsonArray.put(jsonObject);
            }

            return jsonArray.toString();
        } catch (JSONException e) {
            System.out.println("getOtherData has an Exception");
            return null;
        }

    }


    @RequestMapping(value = "setAnnotation")
    public void RegisterAnnotation(@RequestBody String json, HttpServletResponse response) {
        try {


            System.out.println(json);
            JSONObject jsonObject = new JSONObject(json.toString());
            System.out.println(jsonObject);

            String pdfCore = jsonObject.getString("pdfCore");
            Boolean aBoolean = annotationService.getAntFroUpdate(pdfCore);
            if (aBoolean) {
                try {

                    String annotate = AES.encrypt("annotate", json);
                    annotationService.updateAnt(pdfCore, annotate);
                } catch (GeneralSecurityException e) {

                }
            } else {


                try {

                    String annotate = AES.encrypt("annotate", json);

                    Annotation annotation = new Annotation();
                    annotation.setLink(pdfCore);
                    annotation.setAnnotate(annotate);

                    annotationService.register(annotation);
                    response.setStatus(200);
                } catch (GeneralSecurityException e) {

                    e.printStackTrace();

                }
            }
        } catch (JSONException excp) {
            System.out.println("annotation's json has an Exception ");
            response.setStatus(502);
        }


    }

    @RequestMapping(value = "getAnnotation")
    @ResponseBody
    public String GetAnnotation(@RequestBody String json, HttpServletResponse response) {
        try {
            JSONObject pdfCore = new JSONObject(json);
            String pdf = pdfCore.getString("pdfCore");

            Annotation ant = annotationService.getAnt(pdf);

            String annotation = AES.decrypt("annotate", ant.getAnnotate());
            System.out.println(annotation);
            return annotation;

        } catch (Exception e) {
            response.setStatus(502);
            System.out.println("GetAnnotation has an exception");
            return null;
        }
    }


    @RequestMapping(value = "getCollections")
    @ResponseBody
    public String getCollections() {
        try {
            List<PdfCoreCollection> list = collectionService.getCollections();

            JSONArray jsonArray = new JSONArray();
            for (PdfCoreCollection pdfCoreCollection : list) {
                if (pdfCoreCollection.isRelevant()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", pdfCoreCollection.getId());
                    jsonObject.put("pdfCore", pdfCoreCollection.getPdfCore());
                    jsonObject.put("title", pdfCoreCollection.getTitle());
                    jsonObject.put("score", pdfCoreCollection.getScore());
                    jsonObject.put("percentage", pdfCoreCollection.getPercentage());
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("id", pdfCoreCollection.getMetadataCollection().getId());
                    jsonObject1.put("title", pdfCoreCollection.getMetadataCollection().getTitle());
                    jsonObject1.put("pdfCore", pdfCoreCollection.getMetadataCollection().getPdfCore());
                    jsonObject1.put("semanticTags", pdfCoreCollection.getMetadataCollection().getSemanticTags());
                    jsonObject.put("metadataCollection", jsonObject1);
                    jsonArray.put(jsonObject);
                }

            }


            return jsonArray.toString();
        } catch (Exception e) {
            return null;
        }

    }

}
