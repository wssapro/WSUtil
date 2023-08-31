package cn.ws.blazefire.smtk;

import cn.ws.tools.http.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-09-01 18:49
 */
public class smsapi {
    public static void main(String[] args) {


        MpSmsReq mpSmsReq = new MpSmsReq();

        mpSmsReq.setRd("302074");
        mpSmsReq.setAppKey("9YpFr7s5");
        mpSmsReq.setSecretKey("b4525f41c2f24cdf93296626a53c4960");
        mpSmsReq.setTimestamp(System.currentTimeMillis() + "");


        String str = "POST" + mpSmsReq.getAppKey() + mpSmsReq.getSecretKey() + mpSmsReq.getTimestamp() + mpSmsReq.getRd();
        String md5Str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();

        mpSmsReq.setSign(md5Str);
        ArrayList<String> list = new ArrayList();
        list.add("20220901132401368447417");
        list.add("20220901132401364406596");
        list.add("20220901132401364405613");
        mpSmsReq.setSmsIds(list);

        String s = HttpClientUtil.doPostJson("http://bhgs0w.shwacheng.com:20083/api/repeal", JSON.toJSONString(mpSmsReq));


        System.out.println(s);
    }
}
