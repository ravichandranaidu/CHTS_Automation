package com.ch.occ.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ch.occ.pages.HomePage;
import com.ch.occ.pages.LoginPage;
import com.ch.occ.pages.UrlPage;
import com.ch.occ.utils.PropertyUtil;
import com.ch.tbc.report.utils.AbstractTestCaseReport;
import com.ch.tbc.reports.TestCaseDetail;
import com.ch.tbc.reports.TestCaseFactory;

public class LoginAndLogout extends AbstractTestCaseReport
{
    @BeforeClass
    public void OCCUrl() throws Exception
    {
        UrlPage.getURL();

    }

    @Test
    public void loginTest() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            HomePage.clickLogin();
            LoginPage.enterLogin();
            LoginPage.enterLoginPassword();
            LoginPage.clickLoginButton();
            Thread.sleep(5000);
            HomePage.logoutLink();
            testcase.pass("Login and Logout from the website " + "\"" + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE)
                    + "\"");
        } catch (Exception e)
        {
            testcase.error("Login and Logout from the Website" + "\"" + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE)
            + "\"", e);
            e.printStackTrace();
        }
    }
    
}
