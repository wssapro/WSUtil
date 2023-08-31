package cn.ws.tools.base64;

import cn.ws.tools.ReadLog;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.whatsapp.Me;
import com.whatsapp.ObjectUtil;

import java.util.HashSet;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-09-29 16:20
 */
public class Base64Util {

    private static final int BASE64_FLAG = AndroidBase64.NO_WRAP | AndroidBase64.NO_PADDING | AndroidBase64.URL_SAFE;


    public static void main(String[] args) {


        // test();

        HashSet<String> set = new HashSet<>();
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\MassCallbackLog.20220118.0.log");
        for (String s : read) {
            try {
                JSONObject object = JSONObject.parseObject(s);
                if (object.getInteger("status")==2) {
                    String phone = object.getString("phone");
                    set.add(phone);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("11111");
    }


    public static void test(){
        HashSet<String> set = new HashSet<>();
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\A.txt");
        for (String s : read) {
            JSONArray object = JSONArray.parseArray(s);
            for (Object value : object) {
                try {
                    JSONObject o = (JSONObject) value;
                    String me = o.getString("me");

                    byte[] decode = AndroidBase64.decode(me, BASE64_FLAG);

                    Me me1 = (Me) ObjectUtil.readObjectByteArray(decode);
                    System.out.println(me1.jabber_id);
                    set.add(me1.jabber_id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (String s : set) {
            System.out.println(s);
        }




    }
    public static void test2(){
        String me = "PD94bWwgdmVyc2lvbj0nMS4wJyBlbmNvZGluZz0ndXRmLTgnIHN0YW5kYWxvbmU9J3llcycgPz4KPG1hcD4KICAgIDxzdHJpbmcgbmFtZT0ic2VydmVyX3N0YXRpY19wdWJsaWMiPnFKV3ZTdHROb3BxZ1EyQ2dYWVRjNGptU1VLV2QxUnYyUVRNYlF5WXBLd1k8L3N0cmluZz4KICAgIDxzdHJpbmcgbmFtZT0iY2xpZW50X3N0YXRpY19rZXlwYWlyX3B3ZF9lbmMiPlsyLCZxdW90O3dRdVpwZmNuV0IrRERIYVJ2QVpuK0REZDR5WWsrWVV5ZytHeEZFMXU1bXFmYmJKdU1XdGFMRUgzNU9GVCtBWXpDSGRvK1RcL0xZYWRlZnNcL2JxR3UwOHcmcXVvdDssJnF1b3Q7aFBaVVVJZnhBT0pFZnhCV0R3VDg4dyZxdW90OywmcXVvdDtXSUdqdmcmcXVvdDssJnF1b3Q7N1wvamlQQjluV0cwM0l1SkpKaXVDNXcmcXVvdDtdPC9zdHJpbmc-CiAgICA8Ym9vbGVhbiBuYW1lPSJjYW5fdXNlcl9hbmRyb2lkX2tleV9zdG9yZSIgdmFsdWU9InRydWUiIC8-CjwvbWFwPgo";
        byte[] decode = AndroidBase64.decode(me, BASE64_FLAG);

        // Object o = ObjectUtil.readObjectByteArray(decode);

        String a = new String(decode);
        System.out.println(a);
    }
}
