/**
 * 
 */
package com.ch.tbc.pages;

import com.ch.tbc.utils.TBCConstants;
import com.ch.tbc.utils.selenium.PropertyUtil;
import com.ch.tbc.utils.selenium.SeleniumUtils;

public class TiresPage implements TBCConstants
{
    public static void radius() throws Exception
    {
        String element = PropertyUtil.getObjectValue(RADIUS);
        SeleniumUtils.clickByXPath(element);
    }

    public static void selectradius() throws Exception
    {
        String element = PropertyUtil.getObjectValue(SELECT_RADIUS);
        SeleniumUtils.clickByLinkText(element);
    }

    public static void width() throws Exception
    {
        String element = PropertyUtil.getObjectValue(WIDTH);
        SeleniumUtils.clickByXPath(element);
    }

    public static void selectwidth() throws Exception
    {
        String element = PropertyUtil.getObjectValue(SELECT_WIDTH);
        SeleniumUtils.clickByLinkText(element);
    }

    public static void dimension() throws Exception
    {
        String element = PropertyUtil.getObjectValue(DIMENSION);
        SeleniumUtils.clickByXPath(element);
    }

    public static void selectdimension() throws Exception
    {
        String element = PropertyUtil.getObjectValue(SELECT_DIMENSION);
        SeleniumUtils.clickByLinkText(element);
    }

    public static void gotyre() throws Exception
    {
        String element = PropertyUtil.getObjectValue(GO_TYRE_SIZE);
        SeleniumUtils.clickByLinkText(element);
    }

    public static boolean IsdisplayedTyre() throws Exception
    {
        String element = PropertyUtil.getObjectValue(ASSERT_TYRE_SIZE);
        return SeleniumUtils.iSDisplayedByLinkText(element);
    }
}
