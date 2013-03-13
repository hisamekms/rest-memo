/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.infra.logging;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;

/**
 *
 * @author ooyamashinnosuke
 */
public class LoggerFactory {
    
    @Produces
    public Logger createLogger(InjectionPoint injectionPoint) {
        return org.slf4j.LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
    }
    
    public static Logger getLogger(Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(clazz);
    }
}
