package cn.ws.blazefire.uadd;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-12-09 11:53
 */
public class Mq {
    public static void main(String[] args) {
        test2();
        test3();
        test4();
    }

    public static void test4() {
        int count = 0;
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\mq\\b.txt");
        for (String s : a) {
            try {
                JSONObject re = JSON.parseObject(s);
                Integer stepIndex = re.getInteger("stepIndex");
                if (stepIndex == 1) {
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(count);
    }

    public static void test3() {
        List<String> b = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\mq\\a.txt");
        for (String s : a) {
            try {
                JSONObject req = JSON.parseObject(s);
                String exclusionKey = req.getString("exclusionKey");
                if (exclusionKey != null && !"".equals(exclusionKey)) {
                    if (!set.contains(exclusionKey)) {
                        b.add(s);
                        set.add(exclusionKey);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        WriteLog.write("C:\\Users\\Host-424\\Desktop\\mq\\b.txt", b, true);
    }

    public static void test2() {
        List<String> b = new ArrayList<>();
        for (int i = 0; i <= 1; i++) {
            List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\mq\\MqLog.20211206." + i + ".log");
            for (String s : a) {
                try {
                        String[] split = s.split("MqLog -");
                        b.add(split[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\mq\\a.txt", b, true);
    }
}
