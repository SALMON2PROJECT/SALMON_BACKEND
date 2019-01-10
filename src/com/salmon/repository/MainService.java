package com.salmon.Repository;

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

        entityManager.persist(entity);

    }
    public void remove(T entity){

        entity=this.entityManager.merge(entity);
        this.entityManager.remove(entity);
    }
    public List<T> getAll(Class<T> aclass){

        try {
            List tList=entityManager.createQuery("select entity from"+aclass.newInstance().getClass().getAnnotation(Entity.class).name()+"entity")
                    .getResultList();
            return tList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    public T find(Class<T> aclass,long id){
        return entityManager.find(aclass,id);
    }
    public void update(T entity){
        entityManager.merge(entity);
    }
}



