
package com.ch.occ.pages;

import java.util.ArrayList;
import java.util.Iterator;

import com.ch.occ.bean.CheckoutBean;
import com.ch.occ.utils.FileUtility;
import com.ch.occ.utils.OCCUtlis;
import com.ch.occ.utils.SeleniumUtils;

public class CheckOutPage
{
    public static void checkout() throws Exception
    {
        ArrayList<CheckoutBean> data = FileUtility.readCheckoutData();
        for (Iterator<CheckoutBean> iterator = data.iterator(); iterator.hasNext();)
        {
            CheckoutBean checkout = (CheckoutBean) iterator.next();
            Thread.sleep(4000);
            OCCUtlis.checkOutRegEmail(checkout.getEmail());
            OCCUtlis.checkOutFirstName(checkout.getFname());
            OCCUtlis.checkOutLastName(checkout.getLname());
            OCCUtlis.checkOutCountry(checkout.getCountry());
            OCCUtlis.addresslane1(checkout.getAddress1());
            OCCUtlis.addresslane2(checkout.getAddress2());
            OCCUtlis.checkOutCity(checkout.getCity());
            OCCUtlis.selectStateRegion(checkout.getStateregion());
            OCCUtlis.checkOutZipcode(checkout.getZipcode());
            OCCUtlis.checkOutPhoneNumber(checkout.getPhonenumber());
            if (SeleniumUtils.isElementExitsByOCCCSSSelector("input[id*=BillAddress]") == true)
            {
                try
                {
                    SeleniumUtils.clickByCSSSelector("input[id*=BillAddress]");
                } catch (Exception e)
                {
                    SeleniumUtils.tab();
                    Thread.sleep(4000);
                    SeleniumUtils.javascriptexecutorDown250();
                    SeleniumUtils.clickByCSSSelector("input[id*=BillAddress]");
                }
            }
            OCCUtlis.checkOutBAFirstName(checkout.getFname());
            OCCUtlis.checkOutBALastName(checkout.getLname());
            OCCUtlis.checkOutBACountry(checkout.getCountry());
            OCCUtlis.addressBAlane1(checkout.getAddress1());
            OCCUtlis.addressBAlane2(checkout.getAddress2());
            OCCUtlis.checkOutBACity(checkout.getCity());
            OCCUtlis.selectBAStateRegion(checkout.getStateregion());
            OCCUtlis.checkOutBAZipcode(checkout.getZipcode());
            OCCUtlis.checkOutPayNameCard(checkout.getNamecard());
            OCCUtlis.checkOutCardType(checkout.getCardtype());
            OCCUtlis.checkOutCardNumber(checkout.getCardnumber());
            OCCUtlis.checkOutCVV(checkout.getCheckoutcvv());
            OCCUtlis.checkOutMonth(checkout.getExpiresmonth());
            OCCUtlis.checkOutYear(checkout.getExpiresyear());
            try
            {
                OCCUtlis.occplaceOrder();
            } catch (Exception e)
            {
                OCCUtlis.occplaceOrder();
            }
        }
    }
}
