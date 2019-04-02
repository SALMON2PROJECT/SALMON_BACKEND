package com.salmon.Services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
@Transactional
public abstract class MainService<T> {
    @PersistenceContext
    EntityManager entityManager;
    public void register(T entity){
        try {


            entityManager.persist(entity);

        }
        catch (DataIntegrityViolationException e){

            System.out.println("Registration has an Exception");
        }
    }
    public void remove(T entity){

        entity=this.entityManager.merge(entity);
        this.entityManager.remove(entity);
    }
    public List<T> getAll(Class<T> aclass){

        try {

            List tList=entityManager.createQuery("select entity from " +aclass.newInstance().getClass().getAnnotation(Entity.class).name() +" entity")
                    .getResultList();

            return tList;
        }catch (Exception e){

            return null;
        }

    }
    public T find(Class<T> aclass,String string){
        return entityManager.find(aclass,string);
    }
    public void update(T entity){
        entityManager.merge(entity);
    }

}



