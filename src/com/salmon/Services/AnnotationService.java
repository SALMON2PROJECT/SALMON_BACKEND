package com.salmon.Services;


import com.salmon.TO.Annotation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class AnnotationService extends MainService<Annotation>{
@PersistenceContext
    private EntityManager entityManager;
public Annotation getAnt(String pdfCore){
    try {

        return (Annotation) entityManager.createQuery("select entity from Ant entity where entity.link =:x").setParameter("x",pdfCore).getSingleResult();

    }
    catch (Exception e){
        System.out.println("ant is null");
        return null;
    }

}
public void updateAnt(String pdfCore,String annotation){
    entityManager.createQuery("update Ant o set o.annotate=:x where o.link=:u")
            .setParameter("x", annotation).setParameter("u", pdfCore).executeUpdate();
}

public boolean getAntFroUpdate(String pdfCore){
    try {
        entityManager.createQuery("select entity from Ant entity where entity.link =:x").setParameter("x",pdfCore).getSingleResult();
        return true;
    }
    catch (Exception e){
        return false;
    }

}
}
