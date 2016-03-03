/**
 * 
 */
package com.ch.tbc.suite;

import org.testng.annotations.Test;

import com.ch.tbc.pages.HomePage;
import com.ch.tbc.pages.StoreLocatorPage;
import com.ch.tbc.pages.UrlPage;
import com.ch.tbc.utils.AbstractTestCase;


public class FindStoreTest extends AbstractTestCase
{
    @Test
    public void FindStore() throws Exception
    {
        UrlPage.loginWithDefaultAdminUser();
        HomePage.findstore();
        StoreLocatorPage.SendFindZip();
        StoreLocatorPage.findstoreBysearch();
        Thread.sleep(2000);
        StoreLocatorPage.pagesourcecont();
        StoreLocatorPage.SelectStore();
        Thread.sleep(3000);
        StoreLocatorPage.clickHome();
        Thread.sleep(3000);
        StoreLocatorPage.pagesourcecont();

    }
}
