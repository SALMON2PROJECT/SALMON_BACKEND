package com.salmon.Services;
import com.salmon.TO.OtherData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OtherDataService extends MainService<OtherData> {
    @PersistenceContext
    private EntityManager entityManager;

    public List getPins(String username) {
        try {


            List pinsAddr;
            pinsAddr = entityManager.createQuery("select entity.LINKADDRESS from otherData entity where entity.USERNAME=:x and entity.PIN=:true")
                    .setParameter("x", username).getResultList();
            return pinsAddr;
        } catch (Exception e) {
            System.out.println("getSpecificData method on OtherDataService has an Exception");
            return null;
        }
    }

    public int setLikes(String externalLink) {
        try {

            int likes= (int) entityManager.createQuery("select entity.LINKS from otherData entity where entity.LINKADDRESS=:x")
                    .setParameter("x", externalLink).getSingleResult();
            return likes+1;


        } catch (Exception e) {

            return 1;
        }
    }
    public int setDislike(String externalLink){

        try {

            int dislikes= (int) entityManager.createQuery("select entity.DISLIKE from otherData entity where entity.LINKADDRESS=:x")
                    .setParameter("x", externalLink).getSingleResult();
            return dislikes+1;


        } catch (Exception e) {

            return 1;
        }

    }

}



