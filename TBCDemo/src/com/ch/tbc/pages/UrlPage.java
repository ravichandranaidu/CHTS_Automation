package com.ch.tbc.pages;

import com.ch.tbc.utils.TBCConstants;
import com.ch.tbc.utils.selenium.PropertyUtil;
import com.ch.tbc.utils.selenium.SeleniumUtils;

public class UrlPage implements TBCConstants
{
    public static void loginWithDefaultAdminUser()
    {
        getURL();
    }

    public static void getURL()
    {
        String url = PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE);
        SeleniumUtils.get(url);
    }
}
