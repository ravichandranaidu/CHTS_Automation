package com.ch.occ.constants;

public interface FileConstants extends ObjectConstants
{

    public static final String TEST_HOME                 = System.getProperty("test.home", "./");

    public static final String RESOURCES_HOME            = TEST_HOME + "resources/";

    public static final String CONFIG_HOME               = RESOURCES_HOME + "config/";

    public static final String TESTDATA_HOME             = RESOURCES_HOME + "testdata/";

    public static final String LOGIN_DATA_FILE           = TESTDATA_HOME + "LoginTestData.csv";

    public static final String USER_DATA_FILE            = TESTDATA_HOME + "UserData.csv";

    public static final String IMAGE_DATA_FILE           = TESTDATA_HOME + "ImageText.csv";

    public static final String CHECKOUT_DATA             = TESTDATA_HOME + "CheckoutData.csv";

    public static final String REPORTS_HOME              = TEST_HOME + "reports/";

    public static final String DRIVERS_HOME              = RESOURCES_HOME + "drivers/";

    public static final String CHROME                    = DRIVERS_HOME + "chromedriver.exe";

    public static final String PHANTOMJS_WIN             = DRIVERS_HOME + "phantomjs.exe";

    public static final String I_E                       = DRIVERS_HOME + "IEDriverServer.exe";

    public static final String OPERA                     = DRIVERS_HOME + "operadriver.exe";

    public static final String HEAD_FILE                 = CONFIG_HOME + "head.txt";

    public static final String TABLEHEAD_FILE            = CONFIG_HOME + "tablehead.txt";

    public static final String TABLEDETAIL_HEAD_FILE     = CONFIG_HOME + "detailimagehead.txt";

    public static final String TABLEDEATILCASE_HEAD_FILE = CONFIG_HOME + "detailtestcase.txt";

    public static final String TEST_PROPERTY_FILE        = CONFIG_HOME + "testconfig.properties";

    public static final String SERVER_PROPERTY_FILE      = CONFIG_HOME + "server.properties";

    public static final String OBJECT_PROPERTY_FILE      = CONFIG_HOME + "object.properties";

    public static final String BROWSER_PROPERTY_FILE     = CONFIG_HOME + "browser.properties";

    public static final String PLATFORM_NAME             = "platform.name";

    public static final String PLATFORM_VERSION          = "platform.version";

    public static final String DEVICE_NAME               = "device.name";

    public static final String BROWSE_NAME               = "browser";

    public static final String DEVICE_URL                = "driver.url";

    public static final String MOBILE_PC                 = "MOBILE_PC";

    public static final String PLATFORMEXE               = "platformexe.name";

    public static final String APP_NAME                  = "app.name";

    public static final String BROWSER_NAME              = "BROWSER_NAME";

}
