package com.ch.tbc.utils;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ch.tbc.utils.selenium.PropertyUtil;
import com.ch.tbc.utils.selenium.SeleniumUtils;


public class CSSUtility implements TBCConstants
{
    public static void imageAssert()
    {
        WebElement ele = SeleniumUtils.getClass(PropertyUtil.getObjectValue(MAIN_LOGO));
        int img = ele.getSize().getHeight();
        int imwid = ele.getSize().getWidth();
        String st = Integer.toString(img);
        String stw = Integer.toString(imwid);
        String fullsize = st + " " + stw;
        Assert.assertEquals(PropertyUtil.getObjectValue(MAIN_LOGO_PIXLES), fullsize);
        
    }
}
