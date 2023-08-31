package cn.ws.blazefire.uadd;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-11-29 19:32
 */
public class StatisticsMain {
    public static void main(String[] args) {
        String cd = "120006";

        System.out.println(Integer.parseInt(cd)/10000 + "");
        System.out.println(Integer.parseInt(cd)%10000 + "");
        // test2();
        // test3();
        // errore();
        // errorTotal();
    }
    public static void test7() {
        int aaa= 0;
        for (int i = 0; i < 4; i++) {
            List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\HeartbeatLog.20211201."+i+".log");
            for (String s : a) {
                try {
                    JSONObject object = JSON.parseObject(s);
                    String maskEnv = object.getString("maskEnv");

                    // String pattern = ".*[1][0-1]{3}[1][0-1]";
                    String pattern = ".*[1][0-1]{5}";

                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(maskEnv);
                    if(m.find()){
                        aaa++;
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(aaa);
    }
    public static void test6() {
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\b.txt");

        HashMap<String, Integer> hcount = new HashMap();
        for (String s : a) {
            try {
                String[] split = s.split("123321");
                JSONObject re = JSON.parseObject(split[0]);
                JSONObject rsp = JSON.parseObject(split[1]);

                if (rsp.getInteger("status") != 0) {
                    JSONObject pkgInfo = re.getJSONObject("pkgInfo");
                    String version = pkgInfo.getString("vn");
                    String msgEnv = re.getString("msgEnv");
                    version = version + "#" + msgEnv;
                    if (hcount.containsKey(version)) {
                        Integer version1 = hcount.get(version);
                        version1++;
                        hcount.put(version, version1);
                    }
                    else {
                        hcount.put(version, 1);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<String, Integer> entry : hcount.entrySet()) {
            System.out.println(entry.getKey() + "*" + entry.getValue());
        }
    }

    public static void test5() {
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\b.txt");

        HashMap<String, Integer> hcount = new HashMap();
        for (String s : a) {
            try {
                String[] split = s.split("123321");
                JSONObject re = JSON.parseObject(split[0]);
                JSONObject rsp = JSON.parseObject(split[1]);

                if (rsp.getInteger("status") != 0) {
                    JSONObject pkgInfo = re.getJSONObject("pkgInfo");
                    String version = pkgInfo.getString("vn");
                    if (hcount.containsKey(version)) {
                        Integer version1 = hcount.get(version);
                        version1++;
                        hcount.put(version, version1);
                    }
                    else {
                        hcount.put(version, 1);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<String, Integer> entry : hcount.entrySet()) {
            System.out.println(entry.getKey() + "*" + entry.getValue());
        }
    }

    //lastrun 0
    public static void lastrun() {
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\b.txt");

        int count = 0;
        for (String s : a) {
            try {
                String[] split = s.split("123321");
                JSONObject re = JSON.parseObject(split[0]);
                JSONObject counter = re.getJSONObject("counter");
                String lastrun = counter.getString("lastrun");
                if("0".equals(lastrun)){
                    count++;
                }

            } catch (Exception e) {
                // e.printStackTrace();
            }
        }
        System.out.println(count);

    }
    public static void error() {
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\b.txt");

        int error = 0;
        int me = 0;
        int rc2 = 0;
        int key = 0;
        int other = 0;

        HashMap<String,Integer> map = new HashMap<>();
        for (String s : a) {
            try {
                String[] split = s.split("123321");
                JSONObject re = JSON.parseObject(split[0]);
                if(!re.getBoolean("isEnvOk")){
                    error++;
                    String msgEnv = re.getString("msgEnv");
                    String maskEnv = re.getString("maskEnv");

                    String pattern = null;
                    if(maskEnv.length()>=2 && maskEnv.length()<6){
                        pattern = ".*[1][0-1]";
                    }else if(maskEnv.length()>=6){
                        pattern = ".*[0][0-1]{3}[1][0-1]";
                    }

                    if(pattern == null){
                        continue;
                    }

                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(maskEnv);
                    if(m.matches()){
                        System.out.println(pattern+ "," +maskEnv);
                        if(map.containsKey(maskEnv)){
                            Integer integer = map.get(maskEnv);
                            integer++;
                            map.put(maskEnv,integer);
                        }
                        else{
                            map.put(maskEnv,1);
                        }
                    }





                    /*if ("me".equals(msgEnv)) {
                        me++;
                    }else if ("rc2".equals(msgEnv)) {
                        rc2++;
                    }else if ("keypair_pwd_enc".equals(msgEnv)) {
                        key++;
                    }else {
                        other++;
                    }*/
                }

            } catch (Exception e) {
                // e.printStackTrace();
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("error:"+error);
        System.out.println("me:"+me);
        System.out.println("rc2:"+rc2);
        System.out.println("key:"+key);
        System.out.println("other:"+other);

    }
    public static void errore() {
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\b.txt");
        HashMap<String,Integer> map = new HashMap<>();
        for (String s : a) {
            try {
                String[] split = s.split("123321");
                JSONObject re = JSON.parseObject(split[0]);
                if(!re.getBoolean("isEnvOk")){
                    String maskEnv = re.getString("maskEnv");
                    String cd = re.getString("cd");
                        String channel = cd.substring(0,4);
                        maskEnv = channel + "_" + maskEnv;
                        if(map.containsKey(maskEnv)){
                            Integer integer = map.get(maskEnv);
                            integer++;
                            map.put(maskEnv,integer);
                        }
                        else{
                            map.put(maskEnv,1);
                        }
                }
            } catch (Exception e) {
                // e.printStackTrace();
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    public static void errorTotal() {
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\b.txt");

        int error = 0;
        int me = 0;
        int rc2 = 0;
        int key = 0;
        int other = 0;

        HashMap<String,Integer> map = new HashMap<>();
        for (String s : a) {
            try {
                String[] split = s.split("123321");
                JSONObject re = JSON.parseObject(split[0]);


                    String cd = re.getString("cd");
                    if(cd != null){
                        String channel = cd.substring(0,4);

                        if(map.containsKey(channel)){
                            Integer integer = map.get(channel);
                            integer++;
                            map.put(channel,integer);
                        }
                        else{
                            map.put(channel,1);
                        }
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("error:"+error);
        System.out.println("me:"+me);
        System.out.println("rc2:"+rc2);
        System.out.println("key:"+key);
        System.out.println("other:"+other);

    }

    public static void test4() {
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\b.txt");

        HashMap<String, Integer> hcount = new HashMap();
        for (String s : a) {
            try {
                String[] split = s.split("123321");
                JSONObject re = JSON.parseObject(split[0]);
                JSONObject pkgInfo = re.getJSONObject("pkgInfo");
                String version = pkgInfo.getString("vn");
                if (hcount.containsKey(version)) {
                    Integer version1 = hcount.get(version);
                    version1++;
                    hcount.put(version, version1);
                }
                else {
                    hcount.put(version, 1);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<String, Integer> entry : hcount.entrySet()) {
            System.out.println(entry.getKey() + "*" + entry.getValue());
        }
    }

    public static void test3() {
        List<String> b = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\a.txt");
        for (String s : a) {
            try {
                String[] split = s.split("123321");
                JSONObject req = JSON.parseObject(split[0]);
                String imsi = req.getString("imsi");
                if (imsi != null && !"".equals(imsi)) {
                    if (!set.contains(imsi)) {
                        b.add(s);
                        set.add(imsi);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        WriteLog.write("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\b.txt", b, true);
    }

    public static void test2() {
        List<String> b = new ArrayList<>();

        for (int i = 0; i <= 13; i++) {
            List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\HeartbeatLog.20211202." + i + ".log");
            for (String s : a) {
                try {
                    if (s.contains("whatsapp")) {
                        String[] split = s.split("\"request\":");
                        String[] split1 = split[1].split(",\"response\":", 2);
                        b.add(split1[0] + "123321" + split1[1].substring(0, split1[1].length() - 1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        WriteLog.write("C:\\Users\\Host-424\\Desktop\\HeartbeatLog\\a.txt", b, true);
    }

    public static void test1() {
        List<String> a = ReadLog.read("C:\\Users\\Host-424\\Desktop\\d.txt");

        HashMap<String, Integer> hcount = new HashMap();
        for (String s : a) {
            try {
                String[] split = s.split("1233211234567");
                JSONObject re = JSON.parseObject(split[0]);
                JSONObject rsp = JSON.parseObject(split[1]);

                if (rsp.getInteger("status") != 0) {
                    JSONObject pkgInfo = re.getJSONObject("pkgInfo");
                    String version = pkgInfo.getString("vn");
                    String msgEnv = re.getString("msgEnv");
                    version = version + "#" + msgEnv;
                    if (hcount.containsKey(version)) {
                        Integer version1 = hcount.get(version);
                        version1++;
                        hcount.put(version, version1);
                    }
                    else {
                        hcount.put(version, 1);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<String, Integer> entry : hcount.entrySet()) {
            System.out.println(entry.getKey() + "*****" + entry.getValue());
        }
    }
}
