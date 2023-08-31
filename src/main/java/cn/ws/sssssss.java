package cn.ws;

import cn.ws.tools.ReadLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-07-03 11:34
 */
public class sssssss {

    public static void main(String[] args) {

        List<String> read = ReadLog.read("c:\\Users\\Host-424\\Desktop\\rt\\CollectLog_20230713.0.log");
        List<String> read1 = ReadLog.read("c:\\Users\\Host-424\\Desktop\\rt\\CollectLog_20230713.1.log");
        List<String> read2 = ReadLog.read("c:\\Users\\Host-424\\Desktop\\rt\\CollectLog_20230713.2.log");

        read.addAll(read1);
        read.addAll(read2);
        del(read);
    }


    public static HashMap<String, int[]> del(List<String> read){

        HashMap<String, int[]> map = new HashMap<>();
        HashMap<String, Set<String>> pknMap = new HashMap<>();
        for (String s : read) {
            try {
                String[] split = s.split("collect--:");
                String[] split2 = split[0].split(" DEBUG");
                // 定义日期时间格式
                String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                // 解析字符串为LocalDateTime
                LocalDateTime localDateTime = LocalDateTime.parse(split2[0], formatter);
                JSONObject jsonObject = JSON.parseObject(split[1]);
                JSONObject userBase = jsonObject.getJSONObject("userBase");
                JSONObject behaviorBase = jsonObject.getJSONObject("behaviorBase");
                JSONObject messageInfo = JSON.parseObject(behaviorBase.getString("messageInfo"));
                String dataInfo = messageInfo.getString("dataInfo");
                String sericode = userBase.getString("sericode");
                String[] split1 = dataInfo.split("_@_");
                String pkn = split1[0];
                // Integer timezone = TimeZoneUtil.timeChange(localDateTime,messageInfo.getString("timeZone"));

                if (!map.containsKey(pkn)) {
                    map.put(pkn, new int[52]);
                }

                if (!pknMap.containsKey(pkn)) {
                    pknMap.put(pkn, new HashSet<>());
                }
                // if (!pknMap.containsKey(pkn+timezone)) {
                //     pknMap.put(pkn+timezone, new HashSet<>());
                // }
                //
                //
                // map.get(pkn)[0]++;
                // map.get(pkn)[timezone*2+2]++;


                if (!pknMap.get(pkn).contains(sericode)) {
                    map.get(pkn)[1]++;
                    pknMap.get(pkn).add(sericode);
                }

                // if (!pknMap.get(pkn+timezone).contains(sericode)) {
                //     map.get(pkn)[timezone*2+3]++;
                //     pknMap.get(pkn+timezone).add(sericode);
                // }
            } catch (Exception e) {

            }


        }
        for (Map.Entry<String, int[]> stringEntry : map.entrySet()) {
            StringBuilder stringBuffer = new StringBuilder(stringEntry.getKey());
            for (int i : stringEntry.getValue()) {
                stringBuffer.append(":").append(i);
            }
            System.out.println(stringBuffer.toString());
        }
        return map;
    }


}
