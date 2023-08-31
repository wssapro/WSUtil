package cn.ws;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-08-17 14:46
 */
public class asdasd {

    public static Map<String, Integer> exitUuidsTimes = new ConcurrentHashMap<>();


    public static void main(String[] args) {

        exitUuidsTimes.put("test",11112);



        Integer test = exitUuidsTimes.get("test");
        test = test+1;

        Integer test1 = exitUuidsTimes.get("test");
        System.out.println(111);
    }





}
