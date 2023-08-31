package cn.ws.blazefire.log;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-02-17 11:17
 */
public class packageLog {

    private static final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();


    public static void main(String[] args) throws NumberParseException {

        String a = "05146564";
        System.out.println(a.substring(1));
    }
}
