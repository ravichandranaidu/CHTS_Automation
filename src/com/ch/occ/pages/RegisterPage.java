package com.ch.occ.pages;

import java.util.ArrayList;
import java.util.Iterator;

import com.ch.occ.bean.User;
import com.ch.occ.constants.FileConstants;
import com.ch.occ.utils.FileUtility;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;

public class RegisterPage implements FileConstants
{

    public static void registerUsers() throws Exception
    {
        ArrayList<User> getdata = FileUtility.readAllUserData();
        for (Iterator<User> iterator = getdata.iterator(); iterator.hasNext();)
        {
            User user = (User) iterator.next();

            try
            {
                Thread.sleep(2000);
                
                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(REG_FNAME), user.getFirstName());

                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(REG_LNAME), user.getLastName());

                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(REG_EMAIL), user.getEmail());

                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(REG_PASSWORD), user.getPassword());

                SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(REG_CPASSWORD), user.getConfirmPassword());

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void clickSubmit() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(REG_SUBMIT));
    }
}
