package com.ch.tbc.suite;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ch.tbc.pages.HomePage;
import com.ch.tbc.pages.SchedulePage;
import com.ch.tbc.pages.CarModelPage;
import com.ch.tbc.pages.UrlPage;
import com.ch.tbc.utils.AbstractTestCase;
import com.ch.tbc.utils.CSSUtility;

public class LoginTestSuite extends AbstractTestCase
{
    @BeforeTest
    public void TyreUrl() throws Exception
    {
        UrlPage.getURL();
    }

    @Test
    public void TestHomePage() throws Exception
    {
        Assert.assertTrue(HomePage.iSDisplayed());
        HomePage.shopTyres();
    }

    @Test
    public void TestLogoPix()
    {
        CSSUtility.imageAssert();
    }

    @Test
    public void TestSelectionpage() throws Exception
    {
        Assert.assertTrue(CarModelPage.isDisplaySelection());
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
    }

    @Test
    public void Testschedule() throws Exception
    {
        SchedulePage.addschedule();
        SchedulePage.SelectWarrenty();
        Assert.assertTrue(SchedulePage.iSDisplaySchedule());
        SchedulePage.SelectSehcduleButton();
    }

    @AfterTest
    public void Close() throws Exception
    {
        CarModelPage.Close();
    }
}
