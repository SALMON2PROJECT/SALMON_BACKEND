package com.salmon.Services;

import com.salmon.TO.MetadataCollection;
import com.salmon.TO.PdfCoreCollection;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
@Transactional
public class RelevantHandlerService {

    @PersistenceContext
    EntityManager entityManager;

    public void isNotRelevant(Long id, String text, String semanticTags, String title, String url) {

        try {   semanticTags=semanticTags.trim();
                semanticTags=semanticTags.replaceAll(" ",",");
            if (!relevantPdfCore(url)) {
                MetadataCollection collection = new MetadataCollection();
                PdfCoreCollection pdfCoreCollection = new PdfCoreCollection();
                pdfCoreCollection.setPdfCore(url);
                pdfCoreCollection.setTitle(title);
                pdfCoreCollection.setRelevant(true);
                pdfCoreCollection.setPercentage(100);
                pdfCoreCollection.setScore(0);

                collection.setMetaData(text);
                collection.setPdfCore(url);
                collection.setTitle(title);
                collection.setSemanticTags(semanticTags);
                pdfCoreCollection.setMetadataCollection(collection);

                entityManager.persist(collection);
                entityManager.persist(pdfCoreCollection);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public String scoreRate(int score, long id) {
        try {


            PdfCoreCollection pdfCoreCollection = (PdfCoreCollection) entityManager
                    .createQuery("select entity from PdfCoreCollection entity where entity.id=:x")
                    .setParameter("x", id).getSingleResult();
            entityManager.createQuery("update PdfCoreCollection o set o.score=:x+o.score  where o.id=:u")
                    .setParameter("x", score).setParameter("u", id).executeUpdate();
            JSONObject jsonObject = new JSONObject();

            if (pdfCoreCollection.getScore() > -3) {

                jsonObject.put("relevant", true);
                return jsonObject.toString();

            } else {
                entityManager.createQuery("update PdfCoreCollection o set o.relevant=:y where o.id=:u")
                        .setParameter("u", id).setParameter("y", false).executeUpdate();
                System.out.println("false");
                String semantic = (String) entityManager.createQuery("select entity.tags from pdfcore entity where entity.pdfCore=:x")
                        .setParameter("x", pdfCoreCollection.getPdfCore()).getSingleResult();

                long thisId = pdfCoreCollection.getId();

                jsonObject.put("id", thisId);
                jsonObject.put("relevant", false);
                String pdfCore = pdfCoreCollection.getPdfCore();
                pdfCore = pdfCore.replaceAll("  ", "");
                jsonObject.put("pdfCore", pdfCore);
                String text = pdfCoreCollection.getPdfCoreMetaData();
                text = text.replaceAll("     ", "");
                jsonObject.put("text", text);
                String title = pdfCoreCollection.getTitle();
                title = title.replaceAll("  ", "");
                jsonObject.put("title", title);
                semantic = semantic.replaceAll(",", " ");
                semantic = semantic.replaceAll("  ", "");
                jsonObject.put("semanticTags", semantic);

                return jsonObject.toString();

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    boolean relevantPdfCore(String url) {
        List<PdfCoreCollection> pdfCoreCollections = entityManager.createQuery("select entity from PdfCoreCollection entity where entity.pdfCore=:x")
                .setParameter("x", url).getResultList();
        for (PdfCoreCollection pdfCoreCollection : pdfCoreCollections) {
            if (pdfCoreCollection.isRelevant())
                return true;

        }
        return false;
    }

//    String metaDataPdfcore(long id) {
//        try {
//
//            PdfCoreCollection pdfCoreCollection = (PdfCoreCollection) entityManager.createQuery("select entity from PdfCoreCollection entity where entity.id=:x")
//                    .setParameter("x", id).getSingleResult();
//            return pdfCoreCollection.getMetadataCollection().getPdfCore();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//    void modifySemanticTags(String url, String semantics) {
//        try {
//
//            String semanticTags = (String) entityManager.createQuery("select entity.semanticTags from metaData entity where entity.pdfCore=:x")
//                    .setParameter("x", url).getSingleResult();
//
//            semanticTags = semanticTags.replaceAll(",", " ");
//            semantics = semantics.trim();
//            semanticTags = semanticTags.trim();
//            String[] tag = semantics.split(" ");
//            for (String s : tag) {
//
//                semanticTags = semanticTags.replaceAll(s, "");
//
//            }
//            System.out.println("former Tags::::::::::::::::::::::" + semanticTags);
//            /*String tag = " ";
//            for (String finalTag : finalTags) {
//                tag += finalTag;
//
//            }*/
//            System.out.println("new tags:::::::::::::::" + semanticTags);
//            entityManager.createQuery("update metaData o set o.semanticTags=:x where o.pdfCore=:u")
//                    .setParameter("x", semanticTags).setParameter("u", url).executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }

}
