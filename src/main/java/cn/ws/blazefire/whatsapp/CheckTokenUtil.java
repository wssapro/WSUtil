package cn.ws.blazefire.whatsapp;

import cn.ws.tools.StringTool;
import cn.ws.tools.base64.AndroidBase64;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-06-23 17:41
 */
public class CheckTokenUtil {


    public static int BASE64_FLAG = AndroidBase64.NO_WRAP | AndroidBase64.NO_PADDING | AndroidBase64.URL_SAFE;

    public static List<String> check(List<String> zhenglitoken) {
        List<String> checkToken = new ArrayList<>();
        for (String s : zhenglitoken) {
            try {
                JSONObject jsonObject = JSONObject.parseObject(s);
                JSONObject token = jsonObject.getJSONObject("token");
                if (checkToken(token)) {
                    checkToken.add(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return checkToken;
    }

    public static boolean checkToken(JSONObject json) {
        if (!checkFiled(json)) {
            return false;
        }
        if (!checkKeystore(json)) {
            return false;
        }
        return true;
    }

    public static boolean checkFiled(JSONObject json) {
        if (StringTool.isEmpty(json.getString("me"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("registration_jid"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("registrationId"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("publicKey"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("privateKey"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("manufacturer"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("version"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("phoneid_id"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("phone_model"))) {
            return false;
        }
        /*if (StringTool.isEmpty(json.getString("language"))) {
            return false;
        }*/
        if (StringTool.isEmpty(json.getString("region"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("pn"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("routing_info"))) {
            return false;
        }
        if (StringTool.isEmpty(json.getString("keystore"))) {
            return false;
        }
        return true;
    }

    public static boolean checkKeystore(JSONObject json) {
        boolean client_static_keypair_bytes = false;
        try {
            String client_static_keypair = json.getString("client_static_keypairStr");

            if (client_static_keypair == null || "".equals(client_static_keypair)) {

                byte[] keyStoreBytes = keyStoreDecode(json.getString("keystore"));
                if (keyStoreBytes == null) {
                    return false;
                }
                String keystore = new String(keyStoreBytes);

                // System.out.println(keystore);

                String client_static_keypair_enc = null;
                Document doc = Jsoup.parse(keystore);
                Elements childrens = doc.getElementsByTag("map").first().children();
                for (Element child : childrens) {
                    String name = child.attr("name");
                    if (name.equals("client_static_keypair_pwd_enc")) {
                        client_static_keypair_enc = child.text();
                        break;
                    }
                    else if (name.equals("client_static_keypair")) {
                        client_static_keypair = child.text();
                        break;
                    }
                }
                if (client_static_keypair_enc != null && !"".equals(client_static_keypair_enc)) {
                    client_static_keypair_bytes = true;
                }
                else if (client_static_keypair != null && !"".equals(client_static_keypair)) {
                    client_static_keypair_bytes = true;
                }
            }
            else {
                client_static_keypair_bytes = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return client_static_keypair_bytes;
    }


    public static byte[] keyStoreDecode(String str) {
        byte[] keyStoreBytes = null;
        try {
            keyStoreBytes = AndroidBase64.decode(str, BASE64_FLAG);
        } catch (Exception e) {
            // e.printStackTrace();
        }
        if (keyStoreBytes == null) {
            keyStoreBytes = Base64.getDecoder().decode(str);
        }
        return keyStoreBytes;
    }
}
