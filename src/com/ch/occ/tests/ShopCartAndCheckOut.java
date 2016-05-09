package com.ch.occ.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ch.occ.pages.CheckOutPage;
import com.ch.occ.pages.HomePage;
import com.ch.occ.pages.UrlPage;
import com.ch.occ.utils.OCCUtlis;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;
import com.ch.tbc.report.utils.AbstractTestCaseReport;
import com.ch.tbc.reports.TestCaseDetail;
import com.ch.tbc.reports.TestCaseFactory;

public class ShopCartAndCheckOut extends AbstractTestCaseReport
{
    @BeforeClass
    public static void getURL() throws Exception
    {
        UrlPage.getURL();
    }

    @Test
    public void shopProductsTest() throws Exception
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            HomePage.clickAnItem();
            OCCUtlis.selectColorDrop(1);
            OCCUtlis.selecSizeDrop(1);
            Thread.sleep(2000);
            OCCUtlis.selecSizeDrop(1);
            Thread.sleep(2000);
            OCCUtlis.selectquantity("2");
            try
            {
                OCCUtlis.occAddToCart();
            } catch (Exception e)
            {
                SeleniumUtils.tab();
                SeleniumUtils.pageup();
                OCCUtlis.occAddToCart();
            }
            testcase.pass("shoping product, Item Detailpage, Add to Cart " + "\""
                    + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE) + "\"");
        } catch (Exception e)
        {
            testcase.error("shoping product, Item Detailpage, Checkout" + "\""
                    + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE) + "\"", e);
            e.printStackTrace();
        }
    }

    @Test
    public void addToCartAndCheckoutTest()
    {
        String name = new Object()
        {}.getClass().getEnclosingMethod().getName();
        TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
        try
        {
            OCCUtlis.occShopingItems();
            try
            {
                OCCUtlis.occCheckout();
            } catch (Exception e)
            {
                OCCUtlis.occShopingItems();
                OCCUtlis.occCheckout();
            }
            Thread.sleep(5000);
            CheckOutPage.checkout();

            testcase.pass("Checkout " + "\""
                    + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE) + "\"");
        } catch (

        Exception e)
        {
            testcase.error("Checkout" + "\""
                    + PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE) + "\"", e);
            e.printStackTrace();
        }
    }
}
