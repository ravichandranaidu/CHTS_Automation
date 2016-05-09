/**
 * 
 */
package com.ch.tbc.report.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ch.occ.constants.FileConstants;

public class CommonUtility implements FileConstants
{

    public static String getCurrentDate()
    {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("ddMMMYYhhmmss");
        String str = df.format(date);
        return str;
    }
}
