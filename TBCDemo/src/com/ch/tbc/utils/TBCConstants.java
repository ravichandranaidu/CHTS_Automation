package com.ch.tbc.utils;

import com.ch.tbc.utils.objects.ObjectConstants;

public interface TBCConstants extends ObjectConstants
{

    public static final String TEST_HOME            = System.getProperty("test.home", "C:\\Automation\\eclipse\\workspace\\TBCUpdated/");

    public static final String RESOURCES_HOME       = TEST_HOME + "resources/";

    public static final String CONFIG_HOME          = RESOURCES_HOME + "config/";

    public static final String TESTDATA_HOME        = RESOURCES_HOME + "testdata/";

    public static final String LOGIN_DATA_FILE      = TESTDATA_HOME + "LoginTestData.csv";

    public static final String USER_DATA_FILE       = TESTDATA_HOME + "UserData.csv";

    public static final String TEST_PROPERTY_FILE   = CONFIG_HOME + "testconfig.properties";

    public static final String SERVER_PROPERTY_FILE = CONFIG_HOME + "server.properties";

    public static final String OBJECT_PROPERTY_FILE = CONFIG_HOME + "object.properties";

}
