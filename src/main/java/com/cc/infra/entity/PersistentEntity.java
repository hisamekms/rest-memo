/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.infra.entity;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author ooyamashinnosuke
 */
public abstract class PersistentEntity<K extends Serializable> implements Entity, Serializable {

    @Override
    public boolean equals(Object object) {
        if (!getClass().equals(object.getClass())) {
            return false;
        }
        
        PersistentEntity persistentEntity = (PersistentEntity) object;
        
        if (getId() == null && persistentEntity.getId() != null) {
            return false;
        }
        
        if (!getId().equals(persistentEntity.getId())) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        
        hashCode += getId() == null ? 0 : getId().hashCode();
        
        return hashCode;
    }

    @Override
    public boolean isNew() {
        return getId() == null;
    }
    
    @Override
    public abstract K getId();
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
