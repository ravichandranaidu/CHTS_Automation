package com.ch.occ.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.ch.occ.constants.FileConstants;

public class SeleniumUtils extends PropertyUtil implements FileConstants
{

    private static final String CHANGE = PropertyUtil.getConfigValue(MOBILE_PC);

    static WebDriver            driver = null;

    // browser utilis
    @Parameters("browser")
    public static void initializeDriver(String browsername)
    {
        if (browsername.equalsIgnoreCase("firefox"))
        {

            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile myprofile = profile.getProfile("default");
            driver = new FirefoxDriver(myprofile);
        }
        if (browsername.equalsIgnoreCase("IE"))
        {
            System.setProperty("webdriver.ie.driver", I_E);
            driver = new InternetExplorerDriver();
        }
        if (browsername.equalsIgnoreCase("safari"))
        {
            driver = new SafariDriver();
        }
        if (browsername.equalsIgnoreCase("opera"))
        {
            System.setProperty("webdriver.opera.driver", OPERA);
            driver = new OperaDriver();
        }
        if (browsername.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", CHROME);
            driver = new ChromeDriver();
        }
        if (browsername.equalsIgnoreCase("phantomjsWin"))
        {
            System.setProperty("phantomjs.binary.path", PHANTOMJS_WIN);
            driver = new PhantomJSDriver();
        }
    }

    public static void initializeMobileDriver()
    {
        driver = getmobileDriver();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    // choose Device
    public static WebDriver getDriver()
    {
        if (null == driver)
        {
            if (CHANGE.equals("PC"))
            {
                initializeDriver(PropertyUtil.getConfigValue(BROWSER_NAME));
            }
            if (CHANGE.equals("mobile"))
            {
                initializeMobileDriver();
            }
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
        getDriver().navigate().to(url);
        getDriver().manage().window().maximize();
    }

    private static WebDriver getmobileDriver()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", getConfigValue(PLATFORM_NAME));
        caps.setCapability("app", getConfigValue(APP_NAME));
        caps.setCapability("platformVersion", getConfigValue(PLATFORM_VERSION));
        caps.setCapability("deviceName", getConfigValue(DEVICE_NAME));
        caps.setCapability(CapabilityType.BROWSER_NAME, getConfigValue(BROWSE_NAME));
        caps.setCapability(CapabilityType.PLATFORM, PLATFORMEXE);
        return new RemoteWebDriver(getURL(), caps);
    }

    /**
     * @return
     * @throws MalformedURLException
     */
    private static java.net.URL getURL()
    {
        try
        {
            return new URL(getConfigValue(DEVICE_URL));
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    // getting css values
    public static String getCSSValue(String logo, String ele) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logo)));
        Thread.sleep(3000);
        element1.click();
        return element1.getCssValue(ele);

    }

    // click the elements
    public static void clickByXPath(String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        Thread.sleep(3000);
        element1.click();
    }

    public static void clickById(String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        Thread.sleep(3000);
        element1.click();
    }

    public static void clickByLinkText(String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
        Thread.sleep(2000);
        element1.click();
    }

    public static void clickByClass(String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
        Thread.sleep(3000);
        element1.click();
    }

    public static void clickByPartialLink(String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
        Thread.sleep(3000);
        element1.click();
    }

    public static void clickByCSSSelector(String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
        Thread.sleep(3000);
        element1.click();
    }

    public static void clickByName(String element) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
        Thread.sleep(3000);
        element1.click();
    }

    // verify from page source
    public static void PageSoourcecont(String element)
    {
        getDriver().getPageSource().contains(element);
    }

    // send keys
    public static void sendKeysXpath(String element, String data)
    {
        getDriver().findElement(By.xpath(element)).sendKeys(data);
    }

    public static void sendKeysPartialLink(String element, String data)
    {
        getDriver().findElement(By.partialLinkText(element)).sendKeys(data);
    }

    public static void sendKeysClassName(String element, String data)
    {
        getDriver().findElement(By.className(element)).sendKeys(data);
    }

    public static void sendKeysLinkText(String element, String data)
    {
        getDriver().findElement(By.linkText(element)).sendKeys(data);
    }

    public static void sendKeysById(String element, String data)
    {
        getDriver().findElement(By.id(element)).sendKeys(data);
    }

    public static void sendKeysByName(String element, String data)
    {
        getDriver().findElement(By.name(element)).sendKeys(data);
    }

    public static void sendKeysByCSS(String element, String data)
    {
        getDriver().findElement(By.cssSelector(element)).sendKeys(data);
    }

    public static void javascriptexecutorUp250() throws Exception
    {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,-250)", "");
        Thread.sleep(5000);
    }
    
    public static void javascriptexecutorDown250() throws Exception
    {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(5000);
    }

    // JavascriptExecutor je = (JavascriptExecutor) SeleniumUtils.getDriver();
    // je.executeScript("arguments[0].scrollIntoView(true);",
    // SeleniumUtils.getDriver().findElement(By.id("carousel-image-button-wi1500007-0")));
    public static void movetoelemnt(String id)
    {
        WebElement element = getDriver().findElement(By.xpath(id));
        Actions action = new Actions(getDriver());
        action.moveToElement(element).perform();
    }

    public static void pageup()
    {
        Keyboard board = ((HasInputDevices) getDriver()).getKeyboard();
        board.pressKey(Keys.PAGE_UP);
    }
    
    public static void tab()
    {
        Keyboard board = ((HasInputDevices) getDriver()).getKeyboard();
        board.pressKey(Keys.TAB);
    }

    public static void scrollAndClick(String by)
    {
        WebElement element = getDriver().findElement(By.id(by));
        int elementPosition = element.getLocation().getY();
        String js = String.format("window.scroll(0, %s)", elementPosition);
        ((JavascriptExecutor) getDriver()).executeScript(js);
        element.click();
    }

    public static void javaspecial(String ele)
    {
        WebElement element = driver.findElement(By.id(ele));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0," + element.getLocation().y + ")");
        element.click();
    }

    // onhover
    public static void onhoverClickLinkText(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.linkText(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.linkText(element1));
    }

    public static void onhoverClickCss(String element, String element1) throws Exception
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.cssSelector(element));
        actions.moveToElement(ele).build().perform();
        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector(element1)).click();
    }

    public static void onhoverClickName(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.name(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.cssSelector(element1));
    }

    public static void onhoverClickXpath(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.xpath(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.xpath(element1));
    }

    public static void onhoverClickClass(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.className(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.className(element1));
    }

    public static void onhoverClickID(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.id(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.id(element1));
    }

    public static void onhoverClickPartialLink(String element, String element1)
    {
        Actions actions = new Actions(getDriver());
        WebElement ele = getDriver().findElement(By.partialLinkText(element));
        actions.moveToElement(ele).build().perform();
        getDriver().findElement(By.partialLinkText(element1));
    }

    public static void wait(int time) throws Exception
    {
        Thread.sleep(time);
    }

    // drop downs
    public static void XpathDropDownVisibleText(String element, String text)
    {
        Select sel = new Select(getDriver().findElement(By.xpath(element)));
        sel.selectByVisibleText(text);
    }

    public static void xpathDropDownValue(String element, String value)
    {
        Select sel = new Select(getDriver().findElement(By.xpath(element)));
        sel.selectByValue(value);
    }

    public static void xpathDropDownIndex(String element, int index)
    {
        Select sel = new Select(getDriver().findElement(By.xpath(element)));
        sel.selectByIndex(index);
    }

    // id drop down
    public static void dropDownIndexByid(String element, int index) throws Exception
    {
        Select sel = new Select(getDriver().findElement(By.id(element)));
        Thread.sleep(1000);
        sel.selectByIndex(index);
    }

    public static void dropDownVisibleTextByid(String element, String element1)
    {
        Select sel = new Select(getDriver().findElement(By.id(element)));
        sel.selectByVisibleText(element1);
    }

    public static void dropDownIndexBycss(String element, int index) throws Exception
    {
        Select sel = new Select(getDriver().findElement(By.cssSelector(element)));
        Thread.sleep(1000);
        sel.selectByIndex(index);
    }

    public static void dropDownVisibleTextByCSS(String element, String text)
    {
        Select sel = new Select(getDriver().findElement(By.cssSelector(element)));
        sel.selectByVisibleText(text);
    }

    // Boolean is displayed
    public static boolean iSDisplayedByClass(String element)
    {
        return getDriver().findElement(By.className(element)).isDisplayed();
    }

    public static List<WebElement> getAllWebElementsByTagA()
    {
        return getDriver().findElements(By.tagName("a"));
    }

    public static String getAttributes(String element, String element1)
    {
        WebElement ele = getDriver().findElement(By.name(element));

        return ele.getAttribute(element1);
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

    public static boolean isElementExitsByOCCCSSSelector(String element)
    {
        boolean iscssexits = false;
        try
        {
            iscssexits = getDriver().findElement(By.cssSelector(element)).isDisplayed();
        } catch (Exception e)
        {
            e.getMessage();
        }
        return iscssexits;
    }

    // HTML
    public static WebElement getClass(String element)
    {
        WebElement ele = getDriver().findElement(By.className(element));
        return ele;
    }

    // for HTML
    public static WebElement findByElement(String key, String element)
    {
        By byElement = null;
        if (key.equalsIgnoreCase("xpath"))
        {
            byElement = By.xpath(element);
        } else if (key.equalsIgnoreCase("id"))
        {
            byElement = By.id(element);
        } else if (key.equalsIgnoreCase("className"))
        {
            byElement = By.className(element);
        } else if (key.equalsIgnoreCase("name"))
        {
            byElement = By.name(element);
        } else if (key.equalsIgnoreCase("css"))
        {
            byElement = By.cssSelector(element);
        } else if (key.equalsIgnoreCase("linkText"))
        {
            byElement = By.linkText(element);
        } else if (key.equalsIgnoreCase("partialLinkText"))
        {
            byElement = By.partialLinkText(element);
        }
        WebElement ele = getDriver().findElement(byElement);
        return ele;
    }

    public static WebElement getId(String element)
    {
        WebElement ele = getDriver().findElement(By.id(element));
        return ele;
    }
}
