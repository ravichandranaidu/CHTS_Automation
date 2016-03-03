package com.ch.tbc.pages;

import com.ch.tbc.utils.TBCConstants;
import com.ch.tbc.utils.objects.ObjectConstants;
import com.ch.tbc.utils.selenium.PropertyUtil;
import com.ch.tbc.utils.selenium.SeleniumUtils;

public class HomePage implements TBCConstants , ObjectConstants
{
    public static void shopTyres() throws Exception
    {
        String link = PropertyUtil.getObjectValue(SHOPTIRES_LINK);
        SeleniumUtils.clickByXPath(link);
    }

    public static boolean iSDisplayed()
    {
        String element = PropertyUtil.getObjectValue(SHOPTIRES_LINK);
        return SeleniumUtils.iSDisplayedByXPath(element);
    }

    public static void clickOnRegisterButton() throws Exception
    {
        String element = PropertyUtil.getObjectValue(REGISTER_USER);

        SeleniumUtils.clickByLinkText(element);
    }

    public static void clickShopTires() throws Exception
    {
        Thread.sleep(2000);
        String element = PropertyUtil.getObjectValue(SHOP_TYRES_HEADER);
        SeleniumUtils.clickByLinkText(element);
    }

    public static void clickTireByeSize() throws Exception
    {
        String element = PropertyUtil.getObjectValue(TYRE_TYPE);
        SeleniumUtils.clickByLinkText(element);
    }

    public static void clickAddvechicle() throws Exception
    {
        String element = PropertyUtil.getObjectValue(ADD_VECHICHLE);
        SeleniumUtils.clickByLinkText(element);
    }

    public static void findstore() throws Exception
    {
        String element = PropertyUtil.getObjectValue(FIND_STORE_HEADER);
        SeleniumUtils.clickByCSSSelector(element);
    }

    public static void ClickGarage() throws Exception
    {
        String element = PropertyUtil.getObjectValue(GARAGE_HOME);
        SeleniumUtils.clickByCSSSelector(element);
    }

    public static boolean isDisplayedgarage() throws Exception
    {
        String element = PropertyUtil.getObjectValue(GARAGE_CONFIRM);
        return SeleniumUtils.iSDisplayedByLinkText(element);
    }
}
