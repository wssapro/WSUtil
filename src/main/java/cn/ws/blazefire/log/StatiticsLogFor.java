package cn.ws.blazefire.log;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.util.*;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-10-08 11:49
 */
public class StatiticsLogFor {

    public static final Integer FILE_COUNT= 266;
    public static void main(String[] args) {
        // statisticsSericode();
        // statisticsLogicLog();
        // statisticsSericodeDo();
        // statisticsSericodeFail();
        // statistics();


        System.out.println(new Random().nextInt(10));
        System.out.println(new Random(10).nextInt());

    }


    public static void statisticsSericode() {
        HashMap<Integer, Integer> set = new HashMap<>();
        String file = "C:\\Users\\Host-424\\Desktop\\a\\PackageEnterLog_20220323.";
        for (int i = 0; i < 12; i++) {
            List<String> read = ReadLog.read(file + i + ".log");
            for (String s : read) {
                try {
                    String[] a = s.split("-");
                    DCNodeBehaviorPackage node = new Gson().fromJson(a[3], DCNodeBehaviorPackage.class);
                    if (node.getPkid() == 71549048 || node.getPkid() == 20000027 || node.getPkid() == 60001909) {
                        if (node.getType() == 0 && node.getCountryType() == 1) {
                            set.put(node.getUid(), node.getUid());
                        }
                    }
                } catch (Exception e) {
                }
            }
            System.out.println(i);
        }
        System.out.println("all:" + set.size());

        for (Map.Entry<Integer, Integer> entry : set.entrySet()) {
            WriteLog.write("C:\\Users\\Host-424\\Desktop\\Sericode.log", entry.getKey() + "", true);
        }
    }

    public static void statisticsLogicLog() {
        List<String> sericodeList = ReadLog.read("C:\\Users\\Host-424\\Desktop\\sericode.log");
        HashMap<String, Integer> hashMap = new HashMap<>();
        sericodeList.forEach(s -> hashMap.put(s, 0));

        String file222 = "C:\\Users\\Host-424\\Desktop\\b\\ReqAndResLog_20220323.";

        for (int i = 0; i <= FILE_COUNT; i++) {
            List<String> list = new ArrayList<>();
            List<String> read = ReadLog.read(file222 + i + ".log");
            for (String s : read) {
                try {
                    String[] split = s.split("]", 2);
                    String[] split1 = split[1].split("\\[input\\]", 2);
                    JSONObject req = JSONObject.parseObject(split1[0]);
                    String sericode = req.getString("sericode");
                    if (hashMap.containsKey(sericode)) {
                        list.add(split1[0] + "#####" + split1[1]);
                    }
                } catch (Exception e) {
                }
            }
            WriteLog.write("C:\\Users\\Host-424\\Desktop\\log\\log_" + i + ".log", list, true);
        }
    }

    public static void statisticsSericodeDo() {

        HashMap<String, Integer> map = new HashMap<>();

        HashMap<String, Integer> sericodeSuccessMap = new HashMap<>();

        String file222 = "C:\\Users\\Host-424\\Desktop\\log\\log_";

        for (int i = 0; i <= FILE_COUNT; i++) {
            List<String> read = ReadLog.read(file222 + i + ".log");
            for (String s : read) {
                try {
                    String[] split = s.split("#####", 2);

                    JSONObject req = JSONObject.parseObject(split[0]);
                    String sericode = req.getString("sericode");
                    String jmdtype = req.getString("jmdtype");

                    JSONObject resp = JSONObject.parseObject(split[1]);
                    String result = resp.getString("result");

                    if(jmdtype==null){
                        map.put(sericode,1);
                    }

                    if ("0".equals(result)) {

                        JSONArray nodePositionList = resp.getJSONArray("nodePositionList");

                        for (Object o : nodePositionList) {
                            JSONObject jsonObject = (JSONObject) o;
                            Integer businessID = jsonObject.getInteger("businessID");
                            if (businessID == 285) {
                                if (sericodeSuccessMap.containsKey(sericode)) {
                                    Integer integer = sericodeSuccessMap.get(sericode);
                                    integer++;
                                    sericodeSuccessMap.put(sericode, integer);
                                }
                                else {
                                    sericodeSuccessMap.put(sericode, 1);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        }

        List<String> SericodeDo = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            SericodeDo.add(entry.getKey());
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\SericodeDo.log", SericodeDo, true);

        List<String> SericodeSuccess = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sericodeSuccessMap.entrySet()) {
            SericodeSuccess.add(entry.getKey());
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\SericodeSuccess.log", SericodeSuccess, true);
    }

    public static void statisticsSericodeFail() {
        List<String> sericode_do = ReadLog.read("C:\\Users\\Host-424\\Desktop\\SericodeDo.log");

        List<String> sericode_success = ReadLog.read("C:\\Users\\Host-424\\Desktop\\SericodeSuccess.log");

        HashMap<String,String> set = new HashMap<>();
        for (String sericodeSuccess : sericode_success) {
            set.put(sericodeSuccess,sericodeSuccess);
        }

        List<String> dasdad = new ArrayList<>();
        for (String s : sericode_do) {
            if(!set.containsKey(s)){
                dasdad.add(s);
            }
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\SericodeFail.log", dasdad, true);
    }



    public static void statistics() {

        String file222 = "C:\\Users\\Host-424\\Desktop\\a\\task_20220401.";

        HashSet<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < 6; i++) {
            List<String> read = ReadLog.read(file222 + i + ".log");
            for (String s : read) {
                String[] reqs = s.split("req:");
                String[] split = reqs[1].split("#resp");
                JSONObject req = JSONObject.parseObject(split[0]);
                Integer device = req.getInteger("channel");
                if(device == 8014){
                    count++;
                    String imsi = req.getString("imsi");
                    set.add(imsi);
                }

            }

        }


        System.out.println(set.size());
        System.out.println(count);

    }
}
