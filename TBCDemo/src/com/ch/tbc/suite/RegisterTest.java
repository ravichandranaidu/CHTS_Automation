package com.ch.tbc.suite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.ch.tbc.pages.HomePage;
import com.ch.tbc.pages.RegisterPage;
import com.ch.tbc.pages.UrlPage;
import com.ch.tbc.utils.AbstractTestCase;
import com.ch.tbc.utils.TBCConstants;
import com.ch.tbc.utils.objects.ObjectConstants;

public class RegisterTest extends AbstractTestCase implements TBCConstants, ObjectConstants
{

    @Test
    public void testRegister() throws Exception
    {
        UrlPage.loginWithDefaultAdminUser();
        HomePage.clickOnRegisterButton();
        RegisterPage.clickOnRegisterButton();
        RegisterPage.registerUsers();
    }

    @AfterTest
    public void quitDriver()
    {}
}
