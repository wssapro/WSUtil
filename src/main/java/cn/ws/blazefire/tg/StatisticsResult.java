package cn.ws.blazefire.tg;

import cn.ws.tools.ReadLog;
import cn.ws.tools.http.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-10-31 16:41
 */
public class StatisticsResult {
    public static void main(String[] args) {
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\LOGS_NURTURE_RESULT\\LOGS_NURTURE_RESULT.20231024.0.log");

        // 10-24 14:04:37 INFO  LOGS_NURTURE_RESULT -{"id":55,"status":true,"tableName":"tg_task_register_detail_20230925","reason":""}
        for (String s : read) {
            try {
                String[] split = s.split("-");
                String s1 = split[2];
                JSONObject jsonObject = JSONObject.parseObject(s1);


                jsonObject.put("loginTime","2023-10-24 03:00:00");
                HttpClientUtil.doPostJson("http://182.16.50.85:20081/TGControlTask/nurture/result",jsonObject.toJSONString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
