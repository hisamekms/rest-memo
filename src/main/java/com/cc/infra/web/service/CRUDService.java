/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.infra.web.service;

import com.cc.infra.entity.PersistentEntity;
import com.cc.infra.repository.JPARepository;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author ooyamashinnosuke
 */
public abstract class CRUDService<R extends JPARepository<E, K>, E extends PersistentEntity<K>, K extends Serializable> {
    
    @Inject
    protected Logger logger;
    
    protected R repository;

    public CRUDService() throws InstantiationException, IllegalAccessException {
        Type superType = getClass().getGenericSuperclass();
        
        if (superType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            Class<R> repositoryClass = (Class<R>) type.getActualTypeArguments()[0].getClass();
            try {
                repository = repositoryClass.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
               logger.error(null, ex);
               throw ex;
            }
        }
    }
    
    public void create(E entity) {
        repository.persist(entity);
    }

    public void edit(E entity) {
        repository.merge(entity);
    }

    public void remove(K id) {
        repository.remove(id);
    }

    public E find(K id) {
        return repository.findById(id);
    }

    public List<E> findAll() {
        return repository.findAll();
    }

}
