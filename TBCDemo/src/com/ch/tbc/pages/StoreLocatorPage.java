/**
 * 
 */
package com.ch.tbc.pages;

import com.ch.tbc.utils.TBCConstants;
import com.ch.tbc.utils.selenium.PropertyUtil;
import com.ch.tbc.utils.selenium.SeleniumUtils;


public class StoreLocatorPage implements TBCConstants

{
    public static void Clickonsearch() throws Exception
    {
        String element = PropertyUtil.getObjectValue(STORE_SEARCH_FIELD);
        SeleniumUtils.clickById(element);
    }

    public static void SendFindZip() throws Exception
    {
        String element = PropertyUtil.getObjectValue(STORE_SEARCH_FIELD_XPA);
        SeleniumUtils.sendKeys(element, CODE_ZIP);
    }

    public static void findstoreBysearch() throws Exception
    {
        String element = PropertyUtil.getObjectValue(FIND_STORE_SEARCH);
        SeleniumUtils.clickByLinkText(element);
    }

    public static void SelectStore() throws Exception
    {
        String element = PropertyUtil.getObjectValue(SELECT_STORE);
        SeleniumUtils.clickByXPath(element);
    }

    public static void clickHome() throws Exception
    {
        String element = PropertyUtil.getObjectValue(HOME_LINK);
        SeleniumUtils.clickById(element);
    }

    public static void pagesourcecont() throws Exception
    {
        SeleniumUtils.getDriver().getPageSource().contains(PropertyUtil.getObjectValue(PAGE_SOURCE_STORE));
    }
}
