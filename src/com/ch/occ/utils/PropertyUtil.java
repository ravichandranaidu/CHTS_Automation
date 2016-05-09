package com.ch.occ.utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.ch.occ.constants.FileConstants;

public class PropertyUtil implements FileConstants
{

    private static Properties readPropertyFile(String fileName)
    {
        Properties properties = new Properties();
        try
        {
            properties.load(new FileInputStream(fileName));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getPropertyValue(String key, String file)
    {
        Properties properties = readPropertyFile(file);

        return properties.getProperty(key);
    }

    // object property file
    public static String getObjectValue(String key)
    {
        Properties properties = readPropertyFile(OBJECT_PROPERTY_FILE);

        return properties.getProperty(key);
    }

    // testconfig file
    public static String getConfigValue(String key)
    {
        Properties properties = readPropertyFile(TEST_PROPERTY_FILE);
        return properties.getProperty(key);
    }
}
