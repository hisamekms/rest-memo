/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.infra.repository;

import com.cc.infra.entity.Entity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ooyamashinnosuke
 */
public interface Repository<E extends Entity, K extends Serializable> {

    E findById(K key);
    List<E> findByNamedQuery(String queryName);
    List<E> findAll();
    E persist(E entity);
    E merge(E entity);
    void remove(E entity);
    void remove(K key);
    
}
