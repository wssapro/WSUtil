package com.whatsapp;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;


public class ObjectUtil {

    /**
     * 字节流反序列化 读Object
     *
     * @param buffer 字节流
     */
    public static Object readObjectByteArray(byte[] buffer) {
        Object object = null;

        try {
            ByteArrayInputStream bai = new ByteArrayInputStream(buffer);
            ObjectInputStream objectInputStream = new ObjectInputStream(bai);
            object = objectInputStream.readObject();
            objectInputStream.close();
            bai.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    public static HashMap<String, String> map = new HashMap<>();

    static {
        map.put("1", "CA");
        map.put("1", "US");
        map.put("1242", "BS");
        map.put("1246", "BB");
        map.put("1264", "AI");
        map.put("1268", "AG");
        map.put("1284", "VG");
        map.put("1345", "KY");
        map.put("1441", "BM");
        map.put("1473", "GD");
        map.put("1649", "TC");
        map.put("1664", "MS");
        map.put("1684", "AS");
        map.put("1758", "LC");
        map.put("1767", "DM");
        map.put("1784", "VC");
        map.put("1787", "PR");
        map.put("1809", "DO");
        map.put("1868", "TT");
        map.put("1869", "KN");
        map.put("20", "EG");
        map.put("211", "SS");
        map.put("212", "MA");
        map.put("213", "DZ");
        map.put("216", "TN");
        map.put("218", "LY");
        map.put("220", "GM");
        map.put("221", "SN");
        map.put("222", "MR");
        map.put("223", "ML");
        map.put("224", "GN");
        map.put("225", "CI");
        map.put("226", "BF");
        map.put("227", "NE");
        map.put("228", "TG");
        map.put("229", "BJ");
        map.put("230", "MU");
        map.put("231", "LR");
        map.put("232", "SL");
        map.put("233", "GH");
        map.put("234", "NG");
        map.put("235", "TD");
        map.put("236", "CF");
        map.put("237", "CM");
        map.put("238", "CV");
        map.put("239", "ST");
        map.put("240", "GQ");
        map.put("241", "GA");
        map.put("242", "CG");
        map.put("243", "CD");
        map.put("244", "AO");
        map.put("245", "GW");
        map.put("248", "SC");
        map.put("249", "SD");
        map.put("250", "RW");
        map.put("251", "ET");
        map.put("252", "SO");
        map.put("253", "DJ");
        map.put("254", "KE");
        map.put("255", "TZ");
        map.put("256", "UG");
        map.put("257", "BI");
        map.put("258", "MZ");
        map.put("260", "ZM");
        map.put("261", "MG");
        map.put("262", "RE");
        map.put("263", "ZW");
        map.put("264", "NA");
        map.put("265", "MW");
        map.put("266", "LS");
        map.put("267", "BW");
        map.put("268", "SZ");
        map.put("269", "KM");
        map.put("27", "ZA");
        map.put("291", "ER");
        map.put("297", "AW");
        map.put("298", "FO");
        map.put("299", "GL");
        map.put("30", "GR");
        map.put("31", "NL");
        map.put("32", "BE");
        map.put("33", "FR");
        map.put("34", "ES");
        map.put("350", "GI");
        map.put("351", "PT");
        map.put("352", "LU");
        map.put("353", "IE");
        map.put("354", "IS");
        map.put("355", "AL");
        map.put("356", "MT");
        map.put("357", "CY");
        map.put("358", "FI");
        map.put("359", "BG");
        map.put("36", "HU");
        map.put("370", "LT");
        map.put("371", "LV");
        map.put("372", "EE");
        map.put("373", "MD");
        map.put("374", "AM");
        map.put("375", "BY");
        map.put("376", "AD");
        map.put("377", "MC");
        map.put("378", "SM");
        map.put("380", "UA");
        map.put("381", "RS");
        map.put("382", "ME");
        map.put("383", "XK");
        map.put("385", "HR");
        map.put("386", "SI");
        map.put("387", "BA");
        map.put("389", "MK");
        map.put("39", "IT");
        map.put("40", "RO");
        map.put("41", "CH");
        map.put("420", "CZ");
        map.put("421", "SK");
        map.put("423", "LI");
        map.put("43", "AT");
        map.put("44", "GB");
        map.put("45", "DK");
        map.put("46", "SE");
        map.put("47", "NO");
        map.put("48", "PL");
        map.put("49", "DE");
        map.put("500", "FK");
        map.put("501", "BZ");
        map.put("502", "GT");
        map.put("503", "SV");
        map.put("504", "HN");
        map.put("505", "NI");
        map.put("506", "CR");
        map.put("507", "PA");
        map.put("508", "PM");
        map.put("509", "HT");
        map.put("51", "PE");
        map.put("52", "MX");
        map.put("53", "CU");
        map.put("54", "AR");
        map.put("55", "BR");
        map.put("56", "CL");
        map.put("57", "CO");
        map.put("58", "VE");
        map.put("590", "GP");
        map.put("591", "BO");
        map.put("592", "GY");
        map.put("593", "EC");
        map.put("595", "PY");
        map.put("597", "SR");
        map.put("598", "UY");
        map.put("599", "SX");
        map.put("60", "MY");
        map.put("61", "AU");
        map.put("62", "ID");
        map.put("63", "PH");
        map.put("64", "NZ");
        map.put("65", "SG");
        map.put("66", "TH");
        map.put("670", "TL");
        map.put("673", "BN");
        map.put("675", "PG");
        map.put("676", "TO");
        map.put("677", "SB");
        map.put("678", "VU");
        map.put("679", "FJ");
        map.put("680", "PW");
        map.put("681", "WF");
        map.put("682", "CK");
        map.put("685", "WS");
        map.put("686", "KI");
        map.put("687", "NC");
        map.put("688", "TV");
        map.put("689", "PF");
        map.put("691", "FM");
        map.put("7", "KZ");
        map.put("7", "RU");
        map.put("81", "JP");
        map.put("82", "KR");
        map.put("84", "VN");
        map.put("852", "HK");
        map.put("853", "MO");
        map.put("855", "KH");
        map.put("856", "LA");
        map.put("86", "CN");
        map.put("880", "BD");
        map.put("886", "TW");
        map.put("90", "TR");
        map.put("91", "IN");
        map.put("92", "PK");
        map.put("93", "AF");
        map.put("94", "LK");
        map.put("95", "MM");
        map.put("960", "MV");
        map.put("961", "LB");
        map.put("962", "JO");
        map.put("963", "SY");
        map.put("964", "IQ");
        map.put("965", "KW");
        map.put("966", "SA");
        map.put("967", "YE");
        map.put("968", "OM");
        map.put("971", "AE");
        map.put("972", "IL");
        map.put("973", "BH");
        map.put("974", "QA");
        map.put("975", "BT");
        map.put("976", "MN");
        map.put("977", "NP");
        map.put("98", "IR");
        map.put("992", "TJ");
        map.put("993", "TM");
        map.put("994", "AZ");
        map.put("995", "GE");
        map.put("996", "KG");
        map.put("998", "UZ");
    }
}