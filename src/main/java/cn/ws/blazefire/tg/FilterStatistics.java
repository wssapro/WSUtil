package cn.ws.blazefire.tg;

import cn.ws.tools.ReadLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-11-20 10:09
 */
public class FilterStatistics {
    public static void main(String[] args) {

        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a\\24.log");

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : read) {
            String[] split = s.split("-");

            String[] split1 = split[6].replace(" phone:","").split(",");


            if (map.containsKey(split1[0])) {
                Integer integer = map.get(split1[0]);
                integer++;
                map.put(split1[0],integer);
            }
            else {
                map.put(split1[0], 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
