package cn.ws.blazefire.uadd;

import cn.ws.tools.ReadLog;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-12-09 15:41
 */
public class Test {
    public static void main(String[] args) {

        AtomicInteger a = new AtomicInteger(0);
        aaa(a);
        System.out.println(a);
    }

    public static void aaa(AtomicInteger a) {
        for (int i = 0; i < 10; i++) {
            a.addAndGet(1);
        }
        System.out.println(a);
    }
    public static void test2() {
        List<String> list = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a.txt");


        HashMap<String,String> map = new HashMap<>();
        for (String s : list) {
            String[] split = s.split("\"request\":");
            String s1 = split[1];


            String[] split1 = s1.split(",\"response\"");


            String json = split1[0];


            JSONObject jsonObject = JSONObject.parseObject(json);
            String sericode = jsonObject.getString("sericode");

            map.put(sericode,sericode);
        }


        System.out.println("1");


    }
}
