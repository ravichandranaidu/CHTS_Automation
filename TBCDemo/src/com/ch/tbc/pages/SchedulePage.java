/**
 * 
 */
package com.ch.tbc.pages;

import com.ch.tbc.utils.TBCConstants;
import com.ch.tbc.utils.selenium.PropertyUtil;
import com.ch.tbc.utils.selenium.SeleniumUtils;


public class SchedulePage implements TBCConstants
{
    public static void addschedule() throws Exception
    {
        String link = PropertyUtil.getObjectValue(ADD_SCHEDULE);
        SeleniumUtils.clickByXPath(link);
    }

    public static void justWantThese() throws Exception
    {
        String link = PropertyUtil.getObjectValue(JUST_WANT_THESE);
        SeleniumUtils.clickByXPath(link);
    }

    public static void SelectWarrenty() throws Exception
    {
        String link = PropertyUtil.getObjectValue(LIFETIME_WARENTY);
        SeleniumUtils.clickByXPath(link);
    }

    public static void SelectSehcduleButton() throws Exception
    {
        String link = PropertyUtil.getObjectValue(ADDSCHEDULE_SECOND);
        SeleniumUtils.clickByXPath(link);
    }

    public static void checkout() throws Exception
    {
        String link = PropertyUtil.getObjectValue(CHECK_OUT);
        SeleniumUtils.clickByClass(link);
    }

    public static boolean iSDisplaySchedule()
    {
        String element = PropertyUtil.getObjectValue(ADDSCHEDULE_SECOND);
        return SeleniumUtils.iSDisplayedByXPath(element);
    }
    public static boolean iSDisable()
    {
        String element = PropertyUtil.getObjectValue(CHECK_OUT);
        return SeleniumUtils.iSDisplayedByClass(element);
    }
    
}
