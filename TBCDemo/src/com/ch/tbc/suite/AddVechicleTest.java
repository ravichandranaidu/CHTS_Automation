/**
 * 
 */
package com.ch.tbc.suite;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ch.tbc.pages.CarModelPage;
import com.ch.tbc.pages.HomePage;
import com.ch.tbc.pages.UrlPage;
import com.ch.tbc.utils.AbstractTestCase;



public class AddVechicleTest extends AbstractTestCase
{

    @BeforeTest
    public void test()
    {

        UrlPage.loginWithDefaultAdminUser();
    }

    @Test
    public void testaddvechle() throws Exception
    {
        UrlPage.loginWithDefaultAdminUser();
        HomePage.clickAddvechicle();
        CarModelPage.selectCar();
        Assert.assertTrue(CarModelPage.iSDisplayedYear());
        CarModelPage.selectYear();
        Assert.assertTrue(CarModelPage.iSDisplayedModel());
        CarModelPage.selectModel();
        Assert.assertTrue(CarModelPage.iSDisplayedModelopt());
        CarModelPage.selectSubModel();
        CarModelPage.BodyType();
        Assert.assertTrue(CarModelPage.iSDisplayTyreopt());
        CarModelPage.TyreSizeType();
        CarModelPage.continuebutton();
        CarModelPage.Zipcode();
        CarModelPage.sendZipcode();
        Assert.assertTrue(CarModelPage.iSDisplayedZip());
        CarModelPage.ZipcodeGo();
        Thread.sleep(4000);
        HomePage.ClickGarage();
        HomePage.isDisplayedgarage();
    }
}
