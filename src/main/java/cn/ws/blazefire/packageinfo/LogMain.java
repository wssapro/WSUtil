package cn.ws.blazefire.packageinfo;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-12-01 17:27
 */
public class LogMain {
    public static void main(String[] args) {
        test3();
    }

    public static void test2() {
        List<String> b = new ArrayList<>();
        List<String> c = new ArrayList<>();

        for (int i = 0; i <= 15; i++) {
            List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\1\\PackageEnterLog_20211130." + i + ".log");
            for (String s : a) {
                try {
                    String[] split = s.split("- \\{");
                    String s1 = "{" + split[1];
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = JSONObject.parseObject(s1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(jsonObject.getInteger("pkid")==42){
                        b.add(s1);
                    }else if(jsonObject.getInteger("pkid")==40798652){
                        c.add(s1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        WriteLog.write("C:\\Users\\Host-424\\Desktop\\1\\b.txt", b, true);
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\1\\c.txt", c, true);
    }
    public static void test3() {
        List<String> b = new ArrayList<>();

        HashSet<String> set = new HashSet<>();

        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\1\\c.txt");
        for (String s : a) {
            try {
                JSONObject jsonObject = JSONObject.parseObject(s);
                String uid = jsonObject.getString("uid");
                if(!set.contains(uid)){
                    set.add(uid);
                    b.add(uid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        WriteLog.write("C:\\Users\\Host-424\\Desktop\\1\\c1.txt", b, true);
    }
}
