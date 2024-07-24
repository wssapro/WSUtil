package cn.ws.blazefire.ip;

import cn.ws.tools.ReadLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-09-25 13:56
 */
public class User {
    public static void main(String[] args) {
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a.txt");

        JSONArray jsonArray = JSON.parseArray(read.get(0));

        HashMap<String,int[]> map = new HashMap();
        for (Object object: jsonArray){
            JSONObject jsonObject = (JSONObject) object;

            String shortCountry = jsonObject.getString("shortCountry");
            String[] s = shortCountry.split("_");
            String country = s[0];
            int deviceType = Integer.parseInt(s[1]);


            int number = jsonObject.getIntValue("number");
            int max = jsonObject.getIntValue("max");


            int[] ints = map.get(country);
            if(ints == null){
                ints = new int[20];
                map.put(country,ints);
            }
            ints[deviceType]+=number;
            ints[deviceType+10]+=max;


        }

        for (Map.Entry<String, int[]> stringEntry : map.entrySet()) {
            System.out.println(stringEntry.getKey()+":"+ Arrays.toString(stringEntry.getValue()));
        }

    }
}
