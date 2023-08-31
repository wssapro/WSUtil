package cn.ws.blazefire.smtk;


import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-08-24 11:15
 */
public class Log {
    public static void main(String[] args) {

        HashMap<String,String> map = new HashMap<>();

        for (int i = 0; i <= 18; i++) {
            String file = "C:\\Users\\Host-424\\Desktop\\c\\task_20220822." + i + ".log";
            List<String> read = read(file);

            for (String s : read) {

                try {
                    String[] split = s.split("#req:");


                    String[] split1 = split[1].split("#resp");

                    String json = split1[0];

                    JSONObject jsonObject = JSONObject.parseObject(json);
                    String imsi = jsonObject.getString("imsi");

                    map.put(imsi,imsi);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            System.out.println(i + ":" + map.size());
        }
        System.out.println(map.size());
    }


    public static List<String> read(String file) {

        List<String> list = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                list.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
