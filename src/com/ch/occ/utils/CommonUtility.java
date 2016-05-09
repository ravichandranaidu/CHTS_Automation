
package com.ch.occ.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

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

    public static void clickLink(String link)
    {
        List<WebElement> aList = SeleniumUtils.getAllWebElementsByTagA();

        for (WebElement el : aList)
        {
            String attribute = el.getAttribute("href");
            if (null != attribute && attribute.contains(link))
            {
                el.click();
                break;
            }
        }
    }
    
    public static void clickAlt(String alttext)
    {
        List<WebElement> aList = SeleniumUtils.getAllWebElementsByTagA();

        for (WebElement el : aList)
        {
            String attribute = el.getAttribute("alt");
            if (null != attribute && attribute.contains(alttext))
            {
                el.click();
                break;
            }
        }
    }
}
