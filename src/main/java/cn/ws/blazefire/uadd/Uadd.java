package cn.ws.blazefire.uadd;

import cn.hutool.http.HttpUtil;
import cn.ws.blazefire.log.Request;
import cn.ws.tools.http.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Calendar;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-10-21 14:18
 */
public class Uadd {
    public static void main(String[] args) {

        // pullFromCY();
        get();
    }

    public static void pullFromCY() {
        Request request = new Request();
        request.apikey = "97K23r099p23d17b894F03w74c382mL9";
        request.cnt = 5;
        request.country = "IN";
        request.t = System.currentTimeMillis();
        request.sig = getSig("769d09S76787v8N66c9kJ34hbi6Dh305", request.apikey, request.country, request.t);
        String url = "http://29nk3w.gnj01.com:30111/token-pool/api/token/pull?"
                + "apikey=" + request.apikey
                + "&country=" + request.country
                + "&t=" + request.t
                + "&sig=" + request.sig
                + "&cnt=" + request.cnt;
        // String s = HttpClientUtil.doGet(url);
        String s = HttpUtil.get(url, 3000);
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(s);

    }

    public static void get() {
        Request request = new Request();
        // request.apikey = "ZNW5p78u3mMPw8LX";
        request.apikey = "lIoP23Q2LgsWhBQQ";
        request.cnt = 1;
        request.country = "IN";
        request.t = System.currentTimeMillis();
        request.sig = getSig("gSNKCN8daNMYaqvp", request.apikey, request.country, request.t);

        String url = "http://180.178.39.124:10092/udaa/api/tiktok1/pull/uk4jfn?"
        // String url = "http://180.178.39.124:10092/udaa/api/telegram/pull/ocougq?"
        // String url = "http://180.178.39.124:10092/udaa/api/wa/yowhatsapp/pull/tujjxt?"
        // String url = "http://180.178.39.124:10092/udaa/api/wa/pull/6fogoz?"
        // String url = "http://180.178.39.124:10092/udaa/api/wa/pull/4ni6zt?"
        // String url = "http://180.178.39.124:10092/udaa/api/wa/gbwhatsapp3/pull/qmlxfs?"
        // String url = "http://180.178.39.124:10092/udaa/api/fb/lite/pull/qvuxkx?"
        // String url = "http://180.178.39.124:10092/udaa/api/viber/pull/xixsbz?"
        // String url = "http://localhost:8080/udaa/api/wa/gbwhatsapp3/pull/qmlxfs?"
        // String url = "http://localhost:8080/udaa/api/telegram/pull/ocougq?"
                + "apikey=" + request.apikey
                + "&country=" + request.country
                + "&t=" + request.t
                + "&sig=" + request.sig
                + "&used=" + 0
                + "&cnt=" + request.cnt;

        long l = System.currentTimeMillis();
        String s = HttpClientUtil.doGet(url);
        System.out.println(System.currentTimeMillis() - l);
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(s);
        // WriteLog.write("C:\\Users\\Host-424\\Desktop\\a.txt", s, true);
        // analysisThread.run();
    }

    public static Thread analysisThread = new Thread(() -> {
        while (true) {
            try {
                Calendar cal = Calendar.getInstance();
                int minute = cal.get(Calendar.MINUTE);

                // 每小时保存数据
                if (minute == 0) {
                    System.out.println(1);
                    Thread.sleep(60 * 1000);
                }

                Thread.sleep(30 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    protected static String getSig(String partnerKey, String apikey, String country, long t) {
        String signString = "";

        signString += "apikey=" + apikey;
        signString += "country=" + country;
        signString += "t=" + t;
        signString += partnerKey;

        return getMD5(signString.getBytes()).toLowerCase();
    }


    public static String getMD5(byte[] source) {
        String s = null;
        char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
            // 所以表示成 16 进制需要 32 个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
                // 转换成 16 进制字符的转换
                byte byte0 = tmp[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
                // >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            s = new String(str); // 换后的结果转换为字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
