
package com.ch.occ.pages;

import com.ch.occ.constants.FileConstants;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;


public class LoginPage implements FileConstants
{
    
    public static void enterLogin() throws Exception
    {
        Thread.sleep(9000);
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(LOGIN_EMAIL), PropertyUtil.getPropertyValue(LOGIN_MAIL, SERVER_PROPERTY_FILE));
    }

    public static void enterLoginPassword()
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(LOGIN_PASSWORD), PropertyUtil.getPropertyValue(LOGIN_PASSWORD, SERVER_PROPERTY_FILE));
    }

    public static void clickLoginButton()throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(LOGIN_BUTTON));
    }
}
