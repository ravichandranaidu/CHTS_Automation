package com.ch.tbc.utils;

import org.testng.annotations.AfterClass;

import com.ch.tbc.utils.selenium.SeleniumUtils;

public class AbstractTestCase
{

    @AfterClass
    public void testQuitDriver()
    {
        SeleniumUtils.quitDriver();
    }

}
