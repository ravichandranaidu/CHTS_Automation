package com.ch.occ.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.ch.occ.constants.FileConstants;
import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.SeleniumUtils;

public class UrlPage implements FileConstants
{
    public static void launchURL() throws Exception
    {
        getURL();
    }

    public static void getURL() throws Exception
    {

        String url = PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE);
        SeleniumUtils.get(url);
        Thread.sleep(10000);
        boolean frame = false;
        // if (frame == true)
        {
            try
            {
                frame = SeleniumUtils.getDriver().switchTo().frame("ju_iframe") != null;
                SeleniumUtils.getDriver().navigate().refresh();
                SeleniumUtils.getDriver().findElement(By.name("newsletter_name")).sendKeys("Test@abc.com" + Keys.ENTER);
                SeleniumUtils.getDriver()
                        .findElement(By.xpath("/html/body/form/div/div[2]/div[1]/div/div/p/strong/span")).click();
                try
                {

                    SeleniumUtils.getDriver()
                            .findElement(By.xpath("/html/body/form/div/div[2]/div[3]/div/div/div/span/span/span/em"))
                            .click();
                } catch (Exception e)
                {

                }
            } catch (Throwable e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
