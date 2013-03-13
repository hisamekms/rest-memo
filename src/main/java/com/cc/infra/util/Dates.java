/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.infra.util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ooyamashinnosuke
 */
public class Dates {
    public static Date now() {
        return Calendar.getInstance().getTime();
    }
}
