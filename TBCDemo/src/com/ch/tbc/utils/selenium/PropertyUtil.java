package com.ch.tbc.utils.selenium;

import java.io.FileInputStream;
import java.util.Properties;

import com.ch.tbc.utils.TBCConstants;

public class PropertyUtil implements TBCConstants
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

    public static String getObjectValue(String key)
    {
        Properties properties = readPropertyFile(OBJECT_PROPERTY_FILE);

        return properties.getProperty(key);
    }
}
