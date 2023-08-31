package cn.ws.blazefire.uadd;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-12-27 11:29
 */
public class CheckMain {
    public static void main(String[] args) {

        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\5ac9f7945d4d4394b45c978288444c88.txt");
        HashMap<String,String> hashMap = new HashMap<>();
        for (String s : read) {
            JSONObject jsonObject = JSONObject.parseObject(s);
            String sericode = jsonObject.getString("sericode");
            hashMap.put(sericode,s);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
            list.add(stringStringEntry.getValue());
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\b.txt",list,true);
    }


}
