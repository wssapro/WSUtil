package cn.ws;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import cn.ws.tools.http.HttpClientUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-05-04 17:16
 */
public class asdasda {
    public static void main(String[] args) {

        // sss();
        // sssss();
        sssssss();
    }

    public static void sssssss(){
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\info111.log");
        List<String> aa = new ArrayList<>();
        for (String s : read) {
            if(s.contains("handlerAdd")){
                continue;
            }
            aa.add(s);

        }

        WriteLog.write("C:\\Users\\Host-424\\Desktop\\info2.log",aa,true);
    }

    public static void sssss() {
        List<String> aaa = new ArrayList<>();
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\TgServer.log");
        for (String s : read) {
            String[] split = s.split("dc_options=", 2);
            String[] dcTxtDomainNames = split[1].split("dc_txt_domain_name");
            aaa.add(dcTxtDomainNames[0]);
            System.out.println(1);
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\TgServer11.log", aaa, true);
    }

    public static void sss() {
        // String[] abbrs = {"IN", "NG", "PK", "ID", "MM", "DO", "BD", "IR", "VN"};
        /*String[] abbrs = {"IN", "ID", "BD", "NG"};
        for (String abbr : abbrs) {
            for (int i = 0; i < 10; i++) {
                // new Thread(() -> HttpClientUtil.doGet("http://182.16.50.85:8000/test/sendCode?abbr="+ abbr+"&num=100")).start();
                // new Thread(() -> HttpClientUtil.doGet("http://182.16.50.85:8000/test/register?abbr="+ abbr+"&num=10")).start();

            }
        }*/

        for (int start = 0; start < 371; ) {
            int end = start + 10;
            if (end > 371) {
                end = 371;
            }
            String url = "http://182.16.50.85:8000/test/check?start=" + start + "&end=" + end;
            // System.out.println(url);
            new Thread(() -> HttpClientUtil.doGet(url)).start();
            start += 10;
        }
    }

    public static void ssdaasfasdsfa() {
        HashMap<String, int[]> hashMap = new HashMap<>();
        List<String> read = ReadLog.read("D:\\logs\\TdClient\\SEND_CODE\\a.log");
        for (String s : read) {
            try {
                String[] split = s.split("---");
                String abbr = split[0];


                if (!hashMap.containsKey(abbr)) {
                    hashMap.put(abbr, new int[10]);
                }

                int[] ints = hashMap.get(abbr);

                if (split[2].contains("true")) {

                    JSONObject jsonObject = JSONObject.parseObject(split[2]);
                    String aaa = split[0] + "---" + split[1] + "---";

                    JSONObject resp = jsonObject.getJSONObject("resp");

                    aaa = aaa + "#" + resp.getString("type") + "#" + resp.getString("next_type");

                    System.out.println(aaa);
                }
                else {
                    System.out.println(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        for (Map.Entry<String, int[]> stringEntry : hashMap.entrySet()) {
            System.out.println(stringEntry.getKey() + "#" + stringEntry.getValue()[0]);
        }

    }

    public static void ssdasfa() {
        HashSet<String> set = new HashSet<>();
        HashMap<String, int[]> hashMap = new HashMap<>();
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\apiPhone_20230709.0.log");
        for (String s : read) {
            String[] split = s.split("-");
            JSONObject jsonObject = JSONObject.parseObject(split[2]);
            JSONArray infos = jsonObject.getJSONArray("infos");
            JSONObject o = (JSONObject) infos.get(0);
            String abbr = o.getString("abbr");


            if (!hashMap.containsKey(abbr)) {
                hashMap.put(abbr, new int[1]);
            }
            hashMap.get(abbr)[0]++;
            // set.add(abbr);
        }

        for (Map.Entry<String, int[]> stringEntry : hashMap.entrySet()) {
            System.out.println(stringEntry.getKey() + "#" + stringEntry.getValue()[0]);
        }

    }

    public static void statisssss() {
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\e.log");

        HashMap<String, HashSet<String>> aaa = new HashMap<>();

        for (String s : read) {
            try {
                String[] split = s.split("##################");
                String cd = split[0];
                String uid = split[1];
                HashSet<String> hashSet;

                if (!aaa.containsKey(cd)) {
                    hashSet = new HashSet<>();
                    aaa.put(cd, hashSet);
                }
                else {
                    hashSet = aaa.get(cd);
                }
                hashSet.add(uid);
            } catch (Exception e) {
                System.out.println(s);
            }
        }


        for (Map.Entry<String, HashSet<String>> stringHashSetEntry : aaa.entrySet()) {
            System.out.println(stringHashSetEntry.getKey() + ":" + stringHashSetEntry.getValue().size());
        }


    }

    public static void statis() {
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\c.log");

        List<String> reaas = new ArrayList<>();

        for (String s : read) {
            String[] split = s.split("]");
            reaas.add(split[0]);
        }


        WriteLog.write("C:\\Users\\Host-424\\Desktop\\d.log", reaas, true);


    }

    public static void read() {
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\b.log");
        List<String> reaas = new ArrayList<>();
        for (String s : read) {
            if (s.endsWith("magic:[3]")) {
                String[] handlerAdds = s.split("handlerAdd");
                reaas.add(handlerAdds[1]);
            }
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\c.log", reaas, true);
    }
}
