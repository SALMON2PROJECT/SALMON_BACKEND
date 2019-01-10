package com.salmon.Repository;

import com.salmon.TO.Roles;
import com.salmon.TO.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Service
@Transactional
public class UserService extends MainService<Users>{
    @PersistenceContext
    private EntityManager entityManager;

    public void roleReg(Roles roles){

        entityManager.persist(roles);
    }
}
