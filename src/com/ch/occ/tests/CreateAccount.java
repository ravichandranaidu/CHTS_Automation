package com.ch.occ.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ch.occ.pages.HomePage;
import com.ch.occ.pages.RegisterPage;
import com.ch.occ.pages.UrlPage;
import com.ch.occ.utils.PropertyUtil;
import com.ch.tbc.report.utils.AbstractTestCaseReport;
import com.ch.tbc.reports.TestCaseDetail;
import com.ch.tbc.reports.TestCaseFactory;

public class CreateAccount extends AbstractTestCaseReport
{
    @BeforeClass
    public void url() throws Exception
    {
        UrlPage.getURL();
    }

    @Test
    public void createAccountTest() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            HomePage.clickRegister();
            RegisterPage.registerUsers();
            RegisterPage.clickSubmit();
            Thread.sleep(5000);
            testcase.pass("Resgister with valid Detalis " + "\"" + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE) + "\"");
        } catch (Exception e)
        {
            testcase.error("Register with Valid Details"+ "\"" + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE) + "\"", e);
            e.printStackTrace();
        }
    }
}
