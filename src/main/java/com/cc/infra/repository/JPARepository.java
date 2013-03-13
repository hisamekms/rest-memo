/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.infra.repository;

import com.cc.infra.entity.PersistentEntity;
import com.cc.infra.logging.LoggerFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import org.slf4j.Logger;


/**
 *
 * @author ooyamashinnosuke
 */
public abstract class JPARepository<E extends PersistentEntity<K>, K extends Serializable> implements Repository<E, K>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    Class<E> entityClass;

    public JPARepository() {
        logger.info("start");
        Type superType = getClass().getGenericSuperclass();
        
        logger.debug("super class is " + superType);
        if (superType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) superType;
            int i = 0;
            for (Type clazz: type.getActualTypeArguments()) {
                logger.debug("type parameter[" + i + "] is " + clazz);
            }
            entityClass = (Class<E>) type.getActualTypeArguments()[0];
        }
        
        logger.debug("end");
    }

    @Override
    public E findById(K key) {
        return entityManager.find(entityClass, key);
    }

    @Override
    public List<E> findAll() {
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(entityClass));
        return entityManager.createQuery(criteria).getResultList();
    }
    
    @Override
    public List<E> findByNamedQuery(String queryName) {
        return entityManager.createNamedQuery(queryName).getResultList();
    }
    
    @Override
    public E persist(E entity) {
        entityManager.persist(entity);
        return entity;
    }
    
    @Override
    public E merge(E entity) {
        return entityManager.merge(entity);
    } 
    
    @Override
    public void remove(E entity) {
        entityManager.remove(entity);
    }
    
    @Override
    public void remove(K key) {
        E entity = findById(key);
        remove(entity);
    }
    
}
