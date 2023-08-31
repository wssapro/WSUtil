package cn.ws.blazefire.smtk;

import cn.ws.tools.ReadLog;
import cn.ws.tools.http.HttpClientUtil;

import java.util.List;
import java.util.Random;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2023-02-21 11:39
 */
public class UssdPhone {
    public static String url = "http://47xNa1.g7e6.com:20082/behavior/phone?";

    public static void main111(String[] args) {
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\1.txt");

        for (String s : read) {
            try {
                String[] split = s.split("#");
                String imsi = split[0];
                String phone = split[1];

                String reqUrl = url + "imsi=" + imsi + "&phone=" + phone;


                HttpClientUtil.doGet(reqUrl);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(1+new Random().nextInt(4));
    }
}
