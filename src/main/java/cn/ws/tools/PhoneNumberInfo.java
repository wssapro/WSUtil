package cn.ws.tools;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

import java.util.Locale;

public class PhoneNumberInfo {

    public static void main(String[] args) {
        String phoneNumber = "+917569473177"; // 替换为您要查询的手机号

        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();

        try {
            Phonenumber.PhoneNumber number = phoneNumberUtil.parse(phoneNumber, null);

            System.out.println(geocoder.getDescriptionForNumber(number, Locale.CHINA));
            System.out.println( phoneNumberUtil.getRegionCodeForNumber(number));

        } catch (Exception e) {
            System.err.println("无法解析手机号：" + e.getMessage());
        }
    }
}
