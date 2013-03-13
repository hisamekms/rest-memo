/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.infra.entity;

import java.io.Serializable;

/**
 *
 * @author ooyamashinnosuke
 */
public interface Entity<K extends Serializable> {

    public abstract boolean isNew();
    public abstract K getId();
}
