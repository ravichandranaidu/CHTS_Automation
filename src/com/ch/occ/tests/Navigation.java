package com.ch.occ.tests;

import org.testng.annotations.Test;

import com.ch.occ.pages.HomePage;
import com.ch.occ.pages.UrlPage;
import com.ch.occ.utils.PropertyUtil;
import com.ch.tbc.report.utils.AbstractTestCaseReport;
import com.ch.tbc.reports.TestCaseDetail;
import com.ch.tbc.reports.TestCaseFactory;

public class Navigation extends AbstractTestCaseReport
{

    @Test
    public void mainNavTest() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            UrlPage.launchURL();
            HomePage.mainNav1();
            Thread.sleep(2000);
            HomePage.mainNav2();
            Thread.sleep(2000);
            HomePage.mainNav3();
            Thread.sleep(2000);
            HomePage.mainNav4();
            testcase.pass("Checking Main navigation " + "\""
                    + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE) + "\"");
        } catch (Exception e)
        {
            testcase.error("Checking Main navigation" + "\""
                    + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE) + "\"", e);
            e.printStackTrace();
        }

    }

    @Test
    public void secondaryNavTest() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            HomePage.secondaryNav1();
            HomePage.secondaryNav2();
            HomePage.secondaryNav3();
            HomePage.secondaryNav4();

            testcase.pass("Checking Secondary navigation " + "\""
                    + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE) + "\"");
        } catch (

        Exception e)
        {
            testcase.error("Checking Secondary navigation" + "\""
                    + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE) + "\"", e);
            e.printStackTrace();
        }
    }
}
