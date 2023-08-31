package cn.ws.blazefire.uadd;

import cn.ws.tools.ReadLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.text.NumberFormat;
import java.util.*;

/**
 * @author : Host-424
 * @date Date : 2021-12-06 10:48
 */
public class Statistics {
    public static void main(String[] args) throws Exception {
        // Scanner scanner = new Scanner(System.in);
        // String date = scanner.next();
        String date = "20211203";
        String path = "C:\\Users\\Host-424\\Desktop\\zip";
        statistics(path,date,true);
    }

    public static void statistics(String path,String date,boolean isZip) {
        List<String> fileList = file(path, date);
        List<String> splicing = splicing(fileList,isZip);
        List<String> heavyDischargeList = heavyDischarge(splicing);

        HashMap<String, Integer> erroreMap = errore(heavyDischargeList);
        HashMap<String, Integer> errorTotalMap = errorTotal(heavyDischargeList);
        for (Map.Entry<String, Integer> entry : erroreMap.entrySet()) {
            String key = entry.getKey();
            String[] kekArr = key.split("_");
            String channel = kekArr[0];
            String maskEnv = kekArr[1];
            Integer total = errorTotalMap.get(channel);
            System.out.println(channel + "*" + mastString(maskEnv) + "*" + entry.getValue() + "*" + total);
        }
    }

    public static List<String> file(String path,String date){
        List<String> fileList = new ArrayList<>();
        File rootFile = new File(path);
        File[] files = rootFile.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.getName().startsWith("HeartbeatLog." + date)) {
                    fileList.add(file.toString());
                }
            }
        }
        return fileList;
    }


    public static String perspnString(Integer mun, Integer total) {
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float) mun / (float) total * 100);
        return result + "%";
    }

    public static String mastString(String maskEnv) {
        StringBuilder stringBuffer = new StringBuilder("异常:");
        //1 : me
        if (maskEnv.length() >= 1 && maskEnv.charAt(maskEnv.length() - 1) == '1') {
            stringBuffer.append("me/");
        }
        //10 : rc2
        if (maskEnv.length() >= 2 && maskEnv.charAt(maskEnv.length() - 2) == '1') {
            stringBuffer.append("rc2/");
        }
        //100 : keystore
        if (maskEnv.length() >= 3 && maskEnv.charAt(maskEnv.length() - 3) == '1') {
            stringBuffer.append("keystore/");
        }
        //1000 : light
        if (maskEnv.length() >= 4 && maskEnv.charAt(maskEnv.length() - 4) == '1') {
            stringBuffer.append("light/");
        }
        //10000 : keystore_empty
        if (maskEnv.length() >= 5 && maskEnv.charAt(maskEnv.length() - 5) == '1') {
            stringBuffer.append("jid/");
        }
        //100000 : keypair_pwd_enc
        if (maskEnv.length() >= 6 && maskEnv.charAt(maskEnv.length() - 6) == '1') {
            stringBuffer.append("keypair_pwd_enc/");
        }
        //1000000 : vpn
        if (maskEnv.length() >= 7 && maskEnv.charAt(maskEnv.length() - 7) == '1') {
            stringBuffer.append("vpn/");
        }
        //10000000 : proxy
        if (maskEnv.length() >= 8 && maskEnv.charAt(maskEnv.length() - 8) == '1') {
            stringBuffer.append("proxy/");
        }
        return stringBuffer.toString();
    }

    // 统计异常
    public static HashMap<String, Integer> errore(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String log : list) {
            try {
                JSONObject re = JSON.parseObject(log);
                if (!re.getBoolean("isEnvOk")) {
                    String maskEnv = re.getString("maskEnv");
                    if (maskEnv == null) {
                        maskEnv = "0";
                    }
                    String cd = re.getString("cd");
                    String channel = cd.substring(0, 4);
                    maskEnv = channel + "_" + maskEnv;
                    if (map.containsKey(maskEnv)) {
                        Integer integer = map.get(maskEnv);
                        integer++;
                        map.put(maskEnv, integer);
                    }
                    else {
                        map.put(maskEnv, 1);
                    }
                }
            } catch (Exception e) {
            }
        }
        return map;
    }

    // 统计渠道总数
    public static HashMap<String, Integer> errorTotal(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String log : list) {
            try {
                JSONObject re = JSON.parseObject(log);

                String cd = re.getString("cd");
                if (cd != null) {
                    String channel = cd.substring(0, 4);

                    if (map.containsKey(channel)) {
                        Integer integer = map.get(channel);
                        integer++;
                        map.put(channel, integer);
                    }
                    else {
                        map.put(channel, 1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    // 去重
    public static List<String> heavyDischarge(List<String> list) {
        List<String> result = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        for (String log : list) {
            try {
                JSONObject req = JSON.parseObject(log);
                String imsi = req.getString("sericode");
                if (imsi != null && !"".equals(imsi)) {
                    if (!set.contains(imsi)) {
                        result.add(log);
                        set.add(imsi);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // 处理log
    public static List<String> splicing(List<String> fileList,boolean isZip) {
        List<String> result = new ArrayList<>();

        for (String path : fileList) {
            List<String> list;
            if(isZip){
                list = ReadLog.readZipLog(path);
            }else {
                list = ReadLog.read(path);
            }
            for (String log : list) {
                try {
                    if (log.contains("whatsapp")) {
                        String[] split = log.split("\"request\":");
                        String[] split1 = split[1].split(",\"response\":", 2);
                        JSONObject req = JSON.parseObject(split1[0]);
                        String cd = req.getString("cd");
                        if (cd != null && cd.length() == 8) {
                            String channel = cd.substring(0, 4);

                            if ("8067".equals(channel) || "8061".equals(channel) || "8059".equals(channel) || "8049".equals(channel)) {
                                result.add(split1[0]);
                            }
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
