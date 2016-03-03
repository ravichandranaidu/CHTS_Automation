package com.ch.tbc.pages;

import java.util.ArrayList;
import java.util.Iterator;

import com.ch.tbc.bean.User;
import com.ch.tbc.utils.TBCConstants;
import com.ch.tbc.utils.file.FileUtility;
import com.ch.tbc.utils.objects.ObjectConstants;
import com.ch.tbc.utils.selenium.PropertyUtil;
import com.ch.tbc.utils.selenium.SeleniumUtils;

public class RegisterPage implements TBCConstants, ObjectConstants
{

    public static void clickOnRegisterButton()
    {
        String element = PropertyUtil.getObjectValue(REGISTER_REGPAGE);
        SeleniumUtils.clickByClass(element);
    }

    public static void registerUsers() throws Exception
    {
        ArrayList<User> userData = FileUtility.readAllUserData();
        for (Iterator<User> iterator = userData.iterator(); iterator.hasNext();)
        {
            try
            {
                User user = iterator.next();

                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(FIRSTNAME), user.getFirstName());
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(LASTNAME), user.getLastName());
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(ADDRESS), user.getAddress());
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(ADDRESS_CONT), user.getContinuedAddress());
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CITY), user.getCity());
                // to do for state
                SeleniumUtils.clickByXPath(PropertyUtil.getObjectValue(STATE_DROP_DOWN));
                SeleniumUtils.clickByLinkText(user.getState());

                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(ZIPCODE_REG), user.getZipCode());

                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(PRIMARY_PHONE), user.getFirstPhone());
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(PRIMARY_PHN_TWO), user.getMiddlePhone());
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(PRIMARY_PHN_THREE), user.getLastPhone());

                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(ALTERNATE_PHN), user.getFirstMobilePhone());
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(ALTERNATE_PHN_TWO), user.getMiddleMobilePhone());
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(ALTERNATE_PHN_THREE), user.getLastMobilePhone());

                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(EMAIL_REG), user.getEmail());
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CONFRIM_EMAIL), user.getConfirmEmail());

                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(PASSWORD_REG), user.getPassword());
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CONFIRM_PASSWORD), user.getConfirmPassword());

                SeleniumUtils.clickByClass(PropertyUtil.getObjectValue(NEXT_REG));
                SeleniumUtils.clickByXPath(PropertyUtil.getObjectValue(KEEP_ADDRESS_REG));
                SeleniumUtils.clickByClass(PropertyUtil.getObjectValue(NEXT_REG));

                Thread.sleep(2000);

                System.out.println(SeleniumUtils.iSDisplayedByClass(PropertyUtil.getObjectValue(ERROR_REG)));
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
