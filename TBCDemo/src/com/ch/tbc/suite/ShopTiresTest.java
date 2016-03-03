package com.ch.tbc.suite;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ch.tbc.pages.HomePage;
import com.ch.tbc.pages.CarModelPage;
import com.ch.tbc.pages.TiresPage;
import com.ch.tbc.pages.UrlPage;
import com.ch.tbc.utils.AbstractTestCase;

public class ShopTiresTest extends AbstractTestCase
{

    @Test
    public void testShopTiresBySize() throws Exception
    {
        UrlPage.loginWithDefaultAdminUser();
        HomePage.clickShopTires();
        HomePage.clickTireByeSize();
        TiresPage.radius();
        Thread.sleep(100);
        TiresPage.selectradius();
        Thread.sleep(1000);
        TiresPage.width();
        TiresPage.selectwidth();
        Thread.sleep(1000);
        TiresPage.dimension();
        TiresPage.selectdimension();
        Thread.sleep(1000);
        TiresPage.gotyre();
        CarModelPage.Zipcode();
        CarModelPage.sendZipcode();
        CarModelPage.ZipcodeGo();
        Thread.sleep(4000);
        Assert.assertTrue(TiresPage.IsdisplayedTyre());
    }
}
