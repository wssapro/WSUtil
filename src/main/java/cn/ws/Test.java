package cn.ws;

import cn.ws.tools.WriteLog;
import cn.ws.tools.http.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-07-03 11:34
 */
public class Test {

    public static void main(String[] args) {

        String originalString = "Hello, 😊 World!Hello, 🌍! This is a test string with emojis 🚀 ✨.";
        String filteredString = removeUtf8Mb4Chars(originalString);
        System.out.println("Filtered String: " + filteredString);
    }

    public static String removeUtf8Mb4Chars(String input) {
        // 正则表达式匹配所有的 UTF-8 MB4 字符
        String utf8mb4Pattern = "[\\x{10000}-\\x{10FFFF}]";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(utf8mb4Pattern);
        Matcher matcher = pattern.matcher(input);

        // 将所有匹配的字符替换为空字符串
        return matcher.replaceAll("");
    }

    public static Deque<String> deque = new ArrayDeque<>();

    static class Task implements Runnable {
        String reportUrl = "http://148.66.21.91:20101/TokenCentre/token/tokenReport";

        @Override
        public void run() {
            while (!deque.isEmpty()) {
                String json = deque.removeFirst();
                JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
                if (json.contains("appId")) {
                    jsonObject.addProperty("poolId", "TG_DY");
                    String s1 = HttpClientUtil.doPostJson(reportUrl, jsonObject.toString());
                    if ("SUCCESS".equals(s1)) {
                        WriteLog.write("C:\\Users\\Host-424\\Desktop\\c.log", jsonObject.get("tkId").getAsString(), true);
                    }
                }
                else {
                    JSONObject report = new JSONObject();
                    report.put("appId", "TG");
                    report.put("poolId", "TG_DY");
                    report.put("tkId", jsonObject.get("tkId").getAsString());
                    report.put("alive", true);
                    report.put("code", 0);
                    String s1 = HttpClientUtil.doPostJson(reportUrl, report.toJSONString());
                    if ("SUCCESS".equals(s1)) {
                        WriteLog.write("C:\\Users\\Host-424\\Desktop\\c.log", jsonObject.get("tkId").getAsString(), true);
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
