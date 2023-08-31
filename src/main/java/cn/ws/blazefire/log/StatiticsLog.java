package cn.ws.blazefire.log;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-10-08 11:49
 */
public class StatiticsLog {

    public static void main(String[] args) {
        main3();
    }
    public static void main1() {

        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a.log");

        HashMap<Integer, String> code = new HashMap<>();

        for (String s : read) {
            String[] split = s.split("- \\{");
            try {
                JSONObject objects = JSON.parseObject("{" + split[1]);
                Integer sericode = objects.getInteger("sericode");
                code.put(sericode,"{" + split[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int num = 0;
        int num1 = 0;
        for (Map.Entry<Integer, String> entry : code.entrySet()) {
            JSONObject objects = JSON.parseObject(entry.getValue());

            String version = objects.getString("version");
            if("1021".equals(version)){
                num++;
            try {
                Boolean replaceStatus = objects.getBoolean("replaceStatus");
                if(replaceStatus){
                    num1++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            }
        }
        System.out.println(num);
        System.out.println(num1);
    }

    public static void main2(){
        for (int i = 0; i < 21; i++) {

        }
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a\\ReqLog20211121."+ 0 +".log");

        HashMap<Integer, String> code = new HashMap<>();

        for (String s : read) {
            String[] split = s.split("[REQ]");
            String[] split2 = split[1].split("[RSP]");
            try {
                JSONObject objects = JSON.parseObject(split2[0]);
                String packageName = objects.getString("packageName");
                if("".equals(packageName)){

                }
                Integer sericode = objects.getInteger("sericode");
                code.put(sericode,split2[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HashMap<String, Integer> set = new HashMap<>();

        for (Map.Entry<Integer, String> entry : code.entrySet()) {
            JSONObject objects = JSON.parseObject(entry.getValue());

            String version = objects.getString("hostVersion")+"#"+objects.getString("deviceFirm");
            if(set.containsKey(version)){
                Integer integer = set.get(version);
                integer++;
                set.put(version,integer);
            }
            else{
                set.put(version,1);
            }
        }
        for (Map.Entry<String, Integer> entry : set.entrySet()) {
            System.out.println(entry.getKey() + "#" + entry.getValue());
        }


        System.out.println("");
    }

    public static void main3(){
        HashMap<Integer, String> code = new HashMap<>();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\ReqLog\\ReqLog20211125."+i+".log");
            for (String s : read) {
                String[] split = s.split("- \\{");
                try {
                    JSONObject objects = JSON.parseObject("{" + split[1]);
                    String msgInfo = objects.getString("msgInfo");
                    String msgID = objects.getString("msgID");
                    if(msgInfo.contains("businessID\":6")){
                        list.add("{" + split[1]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(list.size());
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\ReqLog\\q.txt",list,false);
        HashMap<String, Integer> set = new HashMap<>();
        for (String s : list) {
            try {
                JSONObject objects = JSON.parseObject(s);
                String msgInfo = objects.getString("uid");
                set.put(msgInfo,1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<String> list1 = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : set.entrySet()) {
            list1.add(entry.getKey());
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\ReqLog\\w.txt",list1,false);
        System.out.println(set.size());
    }


    public static void main4(){
        HashMap<String, Integer> set = new HashMap<>();
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\ReqLog\\RequestLog.log");
        for (String s : read) {
            String[] split = s.split("- \\{");
            try {
                JSONObject objects = JSON.parseObject("{" + split[1]);
                String sericode = objects.getString("sericode");
                set.put(sericode,1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : set.entrySet()) {
            list.add(entry.getKey());
        }

        WriteLog.write("C:\\Users\\Host-424\\Desktop\\ReqLog\\b.txt",list,false);
        System.out.println(set.size());
    }

    public static void main5(){

        List<String> list = new ArrayList<>();
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\ReqLog\\a.txt");
        for (String s : read) {
            try {
                JSONObject objects = JSON.parseObject(s);
                String sericode = objects.getString("uid");
                list.add(sericode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\ReqLog\\c.txt",list,false);
    }
}
