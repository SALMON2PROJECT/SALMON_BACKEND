package com.salmon.Services;

import com.salmon.TO.PdfCore;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class PDFCoreService extends MainService<PdfCore> {

    @PersistenceContext
    EntityManager entityManager;

    public String getPdfTags(String uniqueHash) {
        try {


            PdfCore pdfCore = (PdfCore) entityManager.createQuery("select o from pdfcore o where o.uniqueHash=:n")
                    .setParameter("n", uniqueHash).getSingleResult();


            String tags = pdfCore.getTags();
            String getTag[] = tags.split(",");


            JSONObject jsonObject = new JSONObject();

            jsonObject.put("user",pdfCore.getUsername());
            int count = 1;
            for (String s : getTag) {
                jsonObject.put("tag" + count, s);
                count++;

            }
            jsonObject.put("hashkey", pdfCore.getUniqueHash());
            jsonObject.put("date", pdfCore.getDate());
            System.out.println(jsonObject);

            return jsonObject.toString();

        } catch (Exception e) {
            System.out.println("null catched");
            return "false";
        }

    }

    public String getPdfCore(String pdfCore) {
        try {
            PdfCore isPdfCore = (PdfCore) entityManager.createQuery("select o from pdfcore o where o.pdfCore=:x")
                    .setParameter("x", pdfCore).getSingleResult();
            String getTags = isPdfCore.getTags();
            String[] tags = getTags.split(",");
            try {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("date",isPdfCore.getDate());
                jsonObject.put("user",isPdfCore.getUsername());
                //jsonObject.put("hashkey", isPdfCore.getUniqueHash());

                int count = 1;
                for (String tag : tags) {
                    jsonObject.put("tag" + count, tag);
                    count++;

                }
                return jsonObject.toString();
            } catch (JSONException e) {
                return "false";
            }

        } catch (NoResultException e) {

            System.out.println("this pdfcore does not exist");
            return "false";
        }

    }

    public void pdfUpdate(String pdfCore,String tags) {

        entityManager.createQuery("update pdfcore o set o.tags=:x where o.pdfCore=:u")
                .setParameter("x", tags).setParameter("u", pdfCore).executeUpdate();

    }


}
