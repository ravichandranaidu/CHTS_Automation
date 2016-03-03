/**
 * 
 */
package com.ch.tbc.pages;

import com.ch.tbc.utils.TBCConstants;
import com.ch.tbc.utils.selenium.PropertyUtil;
import com.ch.tbc.utils.selenium.SeleniumUtils;

public class CarModelPage implements TBCConstants
{
    public static void selectCar() throws Exception
    {
        String link = PropertyUtil.getObjectValue(SELECT_CAR_MODEL);
        SeleniumUtils.clickByXPath(link);
    }

    public static void selectYear() throws Exception
    {
        String link = PropertyUtil.getObjectValue(CAR_MODEL_YEAR);
        SeleniumUtils.clickByXPath(link);
    }

    public static void selectModel() throws Exception
    {
        String link = PropertyUtil.getObjectValue(CHOOSE_MODEL);
        SeleniumUtils.clickByXPath(link);
    }

    public static void selectSubModel() throws Exception
    {
        String link = PropertyUtil.getObjectValue(SUB_MODEL);
        SeleniumUtils.clickByXPath(link);
    }

    public static void BodyType() throws Exception
    {
        String link = PropertyUtil.getObjectValue(BODY_TYPE);
        SeleniumUtils.clickByXPath(link);
    }

    public static void TyreSizeType() throws Exception
    {
        String link = PropertyUtil.getObjectValue(TYRE_SIZE);
        SeleniumUtils.clickByXPath(link);
    }

    public static void continuebutton() throws Exception
    {
        String link = PropertyUtil.getObjectValue(CONTINUE_BUTTON);
        SeleniumUtils.clickByXPath(link);
    }

    public static void Zipcode() throws Exception
    {
        String link = PropertyUtil.getObjectValue(ZIP_CODE);
        SeleniumUtils.clickByXPath(link);
    }

    public static void sendZipcode()
    {
        String textbox = PropertyUtil.getObjectValue(ZIP_CODE);
        SeleniumUtils.sendKeys(textbox, CODE_ZIP);
    }

    public static void ZipcodeGo() throws Exception
    {
        String link = PropertyUtil.getObjectValue(ZIPCODE_GO);
        SeleniumUtils.clickByXPath(link);
    }

    public static boolean isDisplaySelection()
    {
        String element = PropertyUtil.getObjectValue(ASSERT_SELECTION);
        return SeleniumUtils.iSDisplayedByXPath(element);
    }

    public static boolean iSDisplayedContinue()
    {
        String element = PropertyUtil.getObjectValue(CONTINUE_BUTTON);
        return SeleniumUtils.iSDisplayedByXPath(element);
    }

    public static boolean iSDisplayedZip()
    {
        String element = PropertyUtil.getObjectValue(ZIPCODE_GO);
        return SeleniumUtils.iSDisplayedByXPath(element);
    }

    public static boolean iSDisplayedYear()
    {
        String element = PropertyUtil.getObjectValue(DISPLAY_YEAR);
        return SeleniumUtils.iSDisplayedByXPath(element);
    }

    public static boolean iSDisplayedModel()
    {
        String element = PropertyUtil.getObjectValue(DISPLAY_MODEL);
        return SeleniumUtils.iSDisplayedByXPath(element);
    }

    public static boolean iSDisplayedModelopt()
    {
        String element = PropertyUtil.getObjectValue(DISPLAY_MODEL_OPTIONS);
        return SeleniumUtils.iSDisplayedByXPath(element);
    }

    public static boolean iSDisplayTyreopt()
    {
        String element = PropertyUtil.getObjectValue(DISPLAY_CHOOSETYRES);
        return SeleniumUtils.iSDisplayedByXPath(element);
    }

    public static void Close() throws Exception
    {
        SeleniumUtils.quitDriver();
    }
}
