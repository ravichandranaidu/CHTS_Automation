package com.ch.tbc.utils.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils
{

    static WebDriver driver = null;

    public static void initializeDriver()
    {
        driver = new FirefoxDriver();
    }

    public static WebDriver getDriver()
    {
        if (null == driver)
        {
            initializeDriver();
        }
        return driver;
    }

    public static void quitDriver()
    {
        if (null != driver)
        {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    public static void get(String url)
    {
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }

    public static void clickByXPath(String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        Thread.sleep(3000);
        element1.click();
    }

    public static String getCSSValue(String logo, String ele) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logo)));
        Thread.sleep(3000);
        element1.click();
        return element1.getCssValue(ele);

    }

    public static void clickById(String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        Thread.sleep(3000);
        element1.click();
    }

    public static void clickByLinkText(String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
        Thread.sleep(2000);
        element1.click();
    }

    public static WebElement getClass(String element)
    {
        WebElement ele = getDriver().findElement(By.className(element));
        return ele;
    }

    public static void clickByClass(String element)
    {
        getDriver().findElement(By.className(element)).click();
    }

    public static void clickByText(String element)
    {
        getDriver().findElement(By.linkText(element)).click();
    }

    public static void clickByCSSSelector(String element)
    {
        getDriver().findElement(By.cssSelector(element)).click();
    }

    public static void PageSoourcecont(String element)
    {
        getDriver().getPageSource().contains(element);
    }

    public static void sendKeys(String element, String data)
    {
        getDriver().findElement(By.xpath(element)).sendKeys(data);
    }

    public static void sendKeysById(String element, String data)
    {
        getDriver().findElement(By.id(element)).sendKeys(data);
    }
    
    public static void onhoverclickLinkText(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.linkText(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.linkText(element1));
    }

    public static void onhoverclickcss(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.cssSelector(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.cssSelector(element1));
    }

    public static void onhoverclickXpath(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.xpath(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.xpath(element1));
    }

    public static void onhoverclickclass(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.className(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.className(element1));
    }

    public static void wait(int time) throws Exception
    {
        Thread.sleep(time);
    }

    public static void onhoverclickid(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.id(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.id(element1));
    }

    public static void enterSelectBox(String element, String text)
    {
        Select sel = new Select(getDriver().findElement(By.xpath(element)));
        sel.selectByVisibleText(text);
    }

    // Boolean is displayed

    public static boolean iSDisplayedByClass(String element)
    {
        return getDriver().findElement(By.className(element)).isDisplayed();
    }

    public static boolean iSDisplayedByLinkText(String element)
    {
        return getDriver().findElement(By.linkText(element)).isDisplayed();
    }

    public static boolean iSDisplayedByXPath(String element)
    {
        return getDriver().findElement(By.xpath(element)).isDisplayed();
    }

    public static boolean iSDisplayedByPartialLink(String element)
    {
        return getDriver().findElement(By.partialLinkText(element)).isDisplayed();
    }

    public static boolean iSDisplayedByName(String element)
    {
        return getDriver().findElement(By.name(element)).isDisplayed();
    }

    public static boolean iSDisplayedByID(String element)
    {
        return getDriver().findElement(By.id(element)).isDisplayed();
    }

    public static boolean iSDisplayedByCSSSelector(String element)
    {
        return getDriver().findElement(By.cssSelector(element)).isDisplayed();
    }

}



