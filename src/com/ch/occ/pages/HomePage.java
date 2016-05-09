package com.ch.occ.pages;

import org.openqa.selenium.Alert;

import com.ch.occ.constants.FileConstants;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;


public class HomePage implements FileConstants
{

    public static void clickLogin() throws Exception
    {

        SeleniumUtils.clickById(PropertyUtil.getObjectValue(LOGIN));
    }

    public static void clickRegister() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(REGISTER));

        Thread.sleep(2000);
    }

    public static void logoutLink() throws Exception
    {

        SeleniumUtils.clickById(PropertyUtil.getObjectValue(LOGOUT_LINK));
    }

    public static void myAccount()
    {
        SeleniumUtils.iSDisplayedByID(PropertyUtil.getObjectValue(MY_ACCOUNT));
    }

    public static void mainNav1() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(MAIN_NAV1));
    }

    public static void mainNav2() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(MAIN_NAV2));
    }

    public static void mainNav3() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(MAIN_NAV3));
    }

    public static void mainNav4() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(MAIN_NAV4));
    }

    public static void mainNav5() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(MAIN_NAV5));
    }

    public static void mainNav6() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(MAIN_NAV6));
    }

    public static void secondaryNav1() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(SECONDARY_NAV1));
    }

    public static void secondaryNav2() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(SECONDARY_NAV2));
    }

    public static void secondaryNav3() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(SECONDARY_NAV3));
    }

    public static void secondaryNav4() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(SECONDARY_NAV4));
    }

    public static void secondaryNav5() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(SECONDARY_NAV5));
    }

    public static void secondaryNav6() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(SECONDARY_NAV6));
    }

    public static void clickAnItem() throws Exception
    {
        if (PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE).equalsIgnoreCase(
                "https://ccstore-z1ga.oracleoutsourcing.com/"))
        {
            System.out.println("occ");
            try
            {
                Alert al = SeleniumUtils.getDriver().switchTo().alert();
                al.accept();
                al.dismiss();
            } catch (Throwable e)
            {
                e.getMessage();
            }
            SeleniumUtils.clickByCSSSelector("img.hero-image");
            SeleniumUtils.clickByCSSSelector("div.bg-product-image");
            Thread.sleep(5000);
        } else if (PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE).equalsIgnoreCase(
                PropertyUtil.getPropertyValue(ELAINE_TURNER, SERVER_PROPERTY_FILE)))
        {
            Thread.sleep(5000);
            SeleniumUtils.onhoverClickCss("[id*=Nav_1 ]", "[id*=Nav_1_1]");
            try
            {
                SeleniumUtils.clickById(PropertyUtil.getObjectValue(PRODUCT_ROCKCREEK_SHOESMEN));
            } catch (Exception e)
            {
                SeleniumUtils.pageup();
                SeleniumUtils.clickById("CC-product-grid-displayName-MIWG003");
            }
        } else if (PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE).equalsIgnoreCase(
                PropertyUtil.getPropertyValue(ROCK_CREEK, SERVER_PROPERTY_FILE)))
        {

            SeleniumUtils.clickById("CC-product-image-38255");
            System.out.println("rc");
            Thread.sleep(5000);
        }
    }
}
