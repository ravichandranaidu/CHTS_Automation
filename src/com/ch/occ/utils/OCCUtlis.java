package com.ch.occ.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.ch.occ.constants.FileConstants;

public class OCCUtlis implements FileConstants
{

    public static void occLogin() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(LOGIN));
    }

    public static void occLogout() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(LOGOUT_LINK));
    }

    public static void occRegister() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(REGISTER));
    }

    public static void occAddToCart() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(ADD_TO_CART));
    }

    public static void occShopingItems() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(SHOPPING_ITEMS));
    }

    public static void occCheckout() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(CHECK_OUT));
    }

    public static void occplaceOrder() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(PLACE_ORDER));
    }

    public static void occCheckoutGuest() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(CHECKOUT_GUEST));
    }

    public static void checkOutRegEmail(String email)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_REG_EMAIL), email);
    }

    public static void occCheckoutLoginToAccount() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(CHECKOUT_LOGIN_ACOUNT));
    }

    public static void occcheckoutcreateaccount() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(CHECKOUT_CREATE_AC));
    }

    public static void checkOutFirstName(String name) throws Exception
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_FNAME), name);
    }

    public static void checkOutLastName(String lastname) throws Exception
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_LNAME), lastname);
    }

    public static void checkOutCountry(String country)
    {
        SeleniumUtils.dropDownVisibleTextByid(PropertyUtil.getObjectValue(CHECKOUT_COUNTRY), country);
    }

    public static void addresslane1(String lane1)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_ADDRESS_LANE1), lane1);
    }

    public static void addresslane2(String lane2)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_ADDRESS_LANE2), lane2);
    }

    public static void checkOutCity(String city)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_CITY), city);
    }

    public static void selectStateRegion(int state) throws Exception
    {
        SeleniumUtils.dropDownIndexByid(PropertyUtil.getObjectValue(CHECKOUT_REGION_STATE), state);
    }

    public static void checkOutZipcode(String zipcode)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_ZIPCODE), zipcode);
    }

    public static void checkOutPhoneNumber(String phone)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_PHONE_NUM), phone);
    }

    public static void checkOutBAFirstName(String name) throws Exception
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_BILL_FNAME), name);
    }

    public static void checkOutBALastName(String lastname) throws Exception
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_BILL_LNAME), lastname);
    }

    public static void checkOutBACountry(String country)
    {
        SeleniumUtils.dropDownVisibleTextByid(PropertyUtil.getObjectValue(CHECKOUT_BILL_COUNTRY), country);
    }

    public static void addressBAlane1(String lane1)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_BILL_ADDRESSLANE1), lane1);
    }

    public static void addressBAlane2(String lane2)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_BILL_ADDRESSLANE2), lane2);
    }

    public static void checkOutBACity(String city)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_BILL_CITY), city);
    }

    public static void selectBAStateRegion(int state) throws Exception
    {
        SeleniumUtils.dropDownIndexByid(PropertyUtil.getObjectValue(CHECKOUT_BILL_STATE), state);
    }

    public static void checkOutBAZipcode(String zipcode)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_BILL_ZIPCODE), zipcode);
    }

    public static void checkOutPayNameCard(String payname)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_NAME_CARD), payname);
    }

    public static void checkOutCardType(String card)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_CARD_TYPE), card + Keys.ENTER);
    }

    public static void checkOutCardNumber(String cardnumber)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_CARD_NUM), cardnumber);
    }

    public static void checkOutCVV(String cvv)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_CARD_CVV), cvv);
    }

    public static void checkOutMonth(int month) throws Exception
    {
        SeleniumUtils.dropDownIndexByid(PropertyUtil.getObjectValue(CHECKOUT_CARD_ENDMONTH), month);
    }

    public static void checkOutYear(String year) throws Exception
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_CARD_EDNYEAR), year + Keys.ENTER);
    }

    public static void checkOutPromo(String promocode)
    {
        SeleniumUtils.sendKeysById(PropertyUtil.getObjectValue(CHECKOUT_APPLY_PROMO_CODE), promocode);
    }

    public static void checkOutPromoButton() throws Exception
    {
        SeleniumUtils.clickById(PropertyUtil.getObjectValue(CHECKOUT_APPLY_BUTTON));
    }

    public static void payWithGiftcard() throws Exception
    {
        if (PropertyUtil.getPropertyValue(URL, SERVER_PROPERTY_FILE).equalsIgnoreCase(
                PropertyUtil.getObjectValue(ROCK_CREEK)))
        {
            SeleniumUtils.clickById(PropertyUtil.getObjectValue(CHECKOUT_GIFT_CARD));
        }
    }

    public static void selecSizeDrop(int size) throws Exception
    {

        if (SeleniumUtils.isElementExitsByOCCCSSSelector(PropertyUtil.getObjectValue(ITEM_DETAIL_SIZE_RC_SAND)) == true)
        {
            SeleniumUtils.dropDownIndexBycss(PropertyUtil.getObjectValue(ITEM_DETAIL_SIZE_RC_SAND), size);

        } else if (SeleniumUtils.isElementExitsByOCCCSSSelector(PropertyUtil.getObjectValue(ITEM_DETAIL_SIZE_ET)) == true)
        {
            SeleniumUtils.dropDownIndexBycss(PropertyUtil.getObjectValue(ITEM_DETAIL_SIZE_ET), size);
        } else if (SeleniumUtils.isElementExitsByOCCCSSSelector("select[id*=CLSZ]"))
        {
            Thread.sleep(2000);
            SeleniumUtils.dropDownIndexBycss("select[id*=CLSZ]", size);
        }
    }

    public static void selectColorDrop(int color) throws Exception
    {
        if (SeleniumUtils.isElementExitsByOCCCSSSelector(PropertyUtil.getObjectValue(ITEM_COLOR_SELECT)) == true)
        {
            SeleniumUtils.clickByCSSSelector(PropertyUtil.getObjectValue(ITEM_COLOR_SELECT));

        } else if (SeleniumUtils.isElementExitsByOCCCSSSelector(PropertyUtil.getObjectValue(ITEM_COLOR_DROPDOWN)) == true)
        {
            SeleniumUtils.dropDownIndexBycss(PropertyUtil.getObjectValue(ITEM_COLOR_DROPDOWN), color);
        }
    }

    public static void selectquantity(String name)
    {
        if (SeleniumUtils.isElementExitsByOCCCSSSelector(PropertyUtil.getObjectValue(ITEM_QUANTITY_DROP)) == true)
        {
            SeleniumUtils.sendKeysByCSS(PropertyUtil.getObjectValue(ITEM_QUANTITY_DROP), name + Keys.ENTER);

        } else if (SeleniumUtils.isElementExitsByOCCCSSSelector(PropertyUtil.getObjectValue(ITEM_QUANTITY_ENTER)) == true)
        {
            SeleniumUtils.getDriver().findElement(By.cssSelector(PropertyUtil.getObjectValue(ITEM_QUANTITY_ENTER)))
                    .clear();
            SeleniumUtils.sendKeysByCSS(PropertyUtil.getObjectValue(ITEM_QUANTITY_ENTER), name);
        }
    }

}
