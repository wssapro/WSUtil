package cn.ws.blazefire.log;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-10-08 11:49
 */
public class AmLog {

    public static void main(String[] args) {

        String file ="C:\\Users\\Host-424\\Desktop\\a\\ReqAbroadLog20220223.";

        for (int i = 0; i <= 11; i++) {
            List<String> list = new ArrayList<>();
            List<String> read = ReadLog.read(file + i + ".log");
            for (String s : read) {
                try {
                    String[] split = s.split("43 - ");
                    JSONObject objects = JSON.parseObject(split[1]);
                    Integer msgID = objects.getInteger("msgID");
                    if(msgID == 13 || msgID == 14){
                        String msgInfo = objects.getString("msgInfo");
                        JSONObject msgInfoObject = JSON.parseObject(msgInfo);
                        Integer taskID = msgInfoObject.getInteger("taskID");
                        if(taskID == 27){
                            list.add(split[1]);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            WriteLog.write("C:\\Users\\Host-424\\Desktop\\b\\23.log",list,true);
        }
    }
}
