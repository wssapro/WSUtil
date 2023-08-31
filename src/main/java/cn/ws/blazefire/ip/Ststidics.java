package cn.ws.blazefire.ip;

import cn.ws.tools.ReadLog;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2023-01-04 10:18
 */
public class Ststidics {
    public static void main(String[] args) {
        statisticsDay("C:\\Users\\Host-424\\Desktop\\1.log");
    }


    public static void statisticsDay(String file) {

        HashMap<String, Integer[]> map = new HashMap<>();
        List<String> read = ReadLog.read(file);
        for (String s : read) {
            String[] split = s.split("LOGS_BEHAVIOR -");

            BehaviorReq behaviorReq = JSON.parseObject(split[1], BehaviorReq.class);

            if (behaviorReq.getProxyNode().getAccount().startsWith("user")) {
                String address = behaviorReq.getProxyNode().getAddress();
                if (address!=null && behaviorReq.getResult() == 0) {
                    if (!map.containsKey(address)) {
                        map.put(address, new Integer[]{0, 0});
                    }
                    map.get(address)[0]++;
                }
            }
        }

        for (Map.Entry<String, Integer[]> stringEntry : map.entrySet()) {
            if(stringEntry.getValue()[0] > 1){
                System.out.println(stringEntry.getKey() + "---" + stringEntry.getValue()[0]);
            }
        }


    }
}
