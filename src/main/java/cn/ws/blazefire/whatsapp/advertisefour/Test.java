package cn.ws.blazefire.whatsapp.advertisefour;

import cn.ws.blazefire.whatsapp.CheckTokenUtil;
import cn.ws.blazefire.whatsapp.WhatsAppInfo;
import cn.ws.tools.base64.AndroidBase64;
import com.alibaba.fastjson.JSONObject;
import com.whatsapp.Me;
import com.whatsapp.ObjectUtil;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-07-28 16:40
 */
public class Test {

    public static void main(String[] args) {

        getWhatsAppInfo2("{     \"country\": \"IN\",     \"code\": \"91637530117\",     \"gid\": \"0e5c244c-b67b-4647-9052-3dbd4a97308c\",     \"ipub\": \"MDVDMjQxQzc5RTNDNUI4RUY3ODdGNUY3RTExMENBMUEzNUI1Nzc2MzNBMzEwOEJENzREQUMzMTU0MjE2QTZFQTdE\",     \"channel\": \"f5jM9AxjX8u4x02Bgc\",     \"rid\": \"719666641\",     \"manufacturer\": \"samsung\",     \"uid\": \"6aixg8t393nx0sd9conuiqy2a\",     \"clientKey\": \"AL//AC/xkYS27QBYXL7EgBAtsE8l1YwPyzyGOqEG6FopCwbrIlchOCPyASe37PN9+3uDnHlogg+eLue4b75zdQ\",     \"me\": \"rO0ABXNyAAljb20ueW8uTWXk6K3RrOBlqgIAA0wAAmNjdAASTGphdmEvbGFuZy9TdHJpbmc7TAAJamFiYmVyX2lkcQB-AAFMAAZudW1iZXJxAH4AAXhwdAACOTF0AAw5MTYzNzUzMDExNzB0AAo2Mzc1MzAxMTcw\",     \"keystore\": \"PD94bWwgdmVyc2lvbj0nMS4wJyBlbmNvZGluZz0ndXRmLTgnIHN0YW5kYWxvbmU9J3llcycgPz4KPG1hcD4KICAgIDxsb25nIG5hbWU9ImNsaWVudF9zdGF0aWNfa2V5cGFpcl9lbmNfc3VjY2VzcyIgdmFsdWU9IjkwIiAvPgogICAgPHN0cmluZyBuYW1lPSJjbGllbnRfc3RhdGljX2tleXBhaXJfcHdkX2VuYyI-WzIsJnF1b3Q7aDZ2eTVVTzZKZldDbk5uNm4zUEhXeTJSXC9zV0dhVDNWTDN5U2VxbGdBeGZVNUk1Z3hzQXpjYndwQjRUbjZvYzZ5OXRSTGpTVlBpU2dTOVwvQTBVVEwxdyZxdW90OywmcXVvdDtKOEpRSlRDNjM4UzZVNTZmaHd6MDBBJnF1b3Q7LCZxdW90O1NwM1RNZyZxdW90OywmcXVvdDtmV3did3NVMUMyOGpSbzJVM1VcL3VUZyZxdW90O108L3N0cmluZz4KICAgIDxib29sZWFuIG5hbWU9ImNhbl91c2VyX2FuZHJvaWRfa2V5X3N0b3JlIiB2YWx1ZT0idHJ1ZSIgLz4KICAgIDxzdHJpbmcgbmFtZT0iY2xpZW50X3N0YXRpY19rZXlwYWlyX2VuYyI-WzAsJnF1b3Q7MExodGFqMW1wZk5DQk9MR0xhV01wWlB1RlltKzhvZlprbGJ3dHJNOW1cL3hcL29VbTdpMWc0XC9IdVplZXJnQXhVQkk1bU9xWUltSG1td0hSRDhPbzVsejZITmUxc29MSnM5WG5GSnc4S0pzNGcmcXVvdDssJnF1b3Q7c3ZHV3lIT1d3amxnZTk2QyZxdW90O108L3N0cmluZz4KICAgIDxzdHJpbmcgbmFtZT0ic2VydmVyX3N0YXRpY19wdWJsaWMiPnFKV3ZTdHROb3BxZ1EyQ2dYWVRjNGptU1VLV2QxUnYyUVRNYlF5WXBLd1k8L3N0cmluZz4KPC9tYXA-Cg\",     \"model\": \"SM-A260G\",     \"barnd\": \"samsung\",     \"pushName\": \"\",     \"rc2\": \"rO0ABXVyAAJbQqzzF_gGCFTgAgAAeHAAAAAqAAKleFbYiE0U3pRZIcYRRYsueNsYkF6UHWidXI44DVsIkXum_M5snqE3\",     \"waVersion\": \"2.22.11.75\",     \"logintime\": \"1666052886\",     \"display\": \"OPR6.A260GDDSCAUJ1\",     \"ip\": \"2405:204:800a:121f::8c9:d8b1\",     \"serverKey\": \"qJWvSttNopqgQ2CgXYTc4jmSUKWd1Rv2QTMbQyYpKwY\",     \"kv\": \"4\",     \"version\": \"8.1.0\",     \"ipri\": \"QTA2Q0I5RDA2MTQ1QTUyMzI5NzFENjk2NEQwNUIzNDg5REY3QzJBMDY3NDI1MjQ4NDg3RTc0NTVENEY0MTE3Qg\",     \"spk\": \"MDgwMDEyMjEwNTY3NzdBNzk5MDFCRTc3MjE3OTk0RTZCNjQ5RTlBODIwOEI2NTZCRDNFRDM0NUVEMzlENkY4NjQyQUY2N0FFN0UxQTIwRjgzODJBMDAzOTIxNjBEODQxQjNGMjM3M0UyMEQyNDU3NjA3RDA3MTA1MjAxMkMxMTY3NTE3NkVCRjU4MUY1NDIyNDAxMUFCMzcxOEI5MjFFQkExRjBDMDFGNzJDRjRDNjM2QTRDODFFNjgxREVDMzE1RDQwMEZBQzIwNTJBMDkwMzU5RjRBRjU5RTNCMjhBQURBQTY3MDBGNjhGRkMxNEUwNTJEOTU2NDRGMzMzNzQzRDdEOEI5Mzc4QjEwNUI4RkIwMDI5Njc0RTgxRDE4MzAxMDAwMA\",     \"createTime\": \"1666069318782\",     \"aid\": \"86535e50f5330e09\",     \"board\": \"universal7870_go\",     \"callTime\": \"-1\" }");

    }

    public static WhatsAppInfo getWhatsAppInfo2(String json) {
        WhatsAppInfo whatsAppInfo = null;
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            whatsAppInfo = JSONObject.parseObject(jsonObject.toJSONString(), WhatsAppInfo.class);

            whatsAppInfo.setRegion(jsonObject.getString("country"));
            whatsAppInfo.setPublicKey(jsonObject.getString("clientKey"));
            whatsAppInfo.setPrivateKey(jsonObject.getString("serverKey"));
            whatsAppInfo.setPn(jsonObject.getString("pushName"));
            whatsAppInfo.setAndroid_id(jsonObject.getString("pushName"));
            whatsAppInfo.setRegistration_jid(jsonObject.getString("code"));
            whatsAppInfo.setRc(jsonObject.getString("rc2"));
            whatsAppInfo.setRegistrationId(jsonObject.getString("rid"));
            whatsAppInfo.setAndroid_version(jsonObject.getString("version"));

            whatsAppInfo.setRouting_info("CAgIBQ");
            byte[] buf = AndroidBase64.decode(whatsAppInfo.getMe(), CheckTokenUtil.BASE64_FLAG);
            Me obj = (Me) ObjectUtil.readObjectByteArray(buf);
            whatsAppInfo.setCc(obj.cc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return whatsAppInfo;
    }
}
