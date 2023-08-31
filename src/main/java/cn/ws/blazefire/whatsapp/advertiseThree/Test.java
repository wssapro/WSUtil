package cn.ws.blazefire.whatsapp.advertiseThree;

import cn.ws.tools.ReadLog;
import cn.ws.tools.base64.AndroidBase64;
import cn.ws.tools.http.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whatsapp.Me;
import com.whatsapp.ObjectUtil;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-07-01 14:15
 */
public class Test {

    private static final int BASE64_FLAG = AndroidBase64.NO_WRAP | AndroidBase64.NO_PADDING | AndroidBase64.URL_SAFE;

    public static void main(String[] args) {


        List<WhatsappDlTokenNode> list = new ArrayList<>();
        WhatsappDlNode whatsappDlNode = new WhatsappDlNode();
        whatsappDlNode.setType(1);
        whatsappDlNode.setCd(80270001);
        whatsappDlNode.setImportId(createBillID());
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a.txt");
        for (String s : read) {

            try {
                if(!StringUtils.isEmpty(s)){
                    JSONObject jsonObject = JSON.parseObject(s);

                    String meStr = jsonObject.getString("me");
                    byte[] decode = AndroidBase64.decode(meStr, BASE64_FLAG);
                    Me me = (Me) ObjectUtil.readObjectByteArray(decode);

                    WhatsappDlTokenNode whatsappDlTokenNode = new WhatsappDlTokenNode();
                    whatsappDlTokenNode.setToken(s);
                    whatsappDlTokenNode.setCountry(jsonObject.getString("country"));
                    whatsappDlTokenNode.setPhone(me.jabber_id);
                    whatsappDlTokenNode.setVersion(jsonObject.getString("wa_version"));

                    list.add(whatsappDlTokenNode);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        whatsappDlNode.setList(list);


        String s = HttpClientUtil.doPostJson("http://fexwhj.qz94.com:10092/udaa/mass/add", JSON.toJSONString(whatsappDlNode));
        // String s = HttpClientUtil.doPostJson("http://localhost:8080//udaa/mass/add", JSON.toJSONString(whatsappDlNode));

        System.out.println(1);
    }

    private static synchronized String createBillID() {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        return format.format(new Date())  + String.format("%05d", randomInt);
    }
}
