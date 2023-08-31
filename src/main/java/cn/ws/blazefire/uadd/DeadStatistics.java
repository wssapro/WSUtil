package cn.ws.blazefire.uadd;

import cn.ws.tools.ReadLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-10-28 11:34
 */
public class DeadStatistics {
    public static void main(String[] args) {

        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\1.log");
        int[] count = new int[40];
        for (String s : read) {
            try {
                JSONObject jsonObject = JSON.parseObject(s);
                if(jsonObject.getInteger("aid") == 16){
                    JSONArray msgData = jsonObject.getJSONArray("msgData");
                    for (int i = 0; i < 40; i++) {
                        count[i] += (Integer) msgData.get(i);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(i+1 + ":" + count[i]);
        }
        System.out.println(Arrays.toString(count));
    }
}