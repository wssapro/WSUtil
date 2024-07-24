package cn.ws.blazefire.smtk;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import jodd.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-07-25 15:04
 */
public class Test {
    public static void main(String[] args) {


        System.out.println(getModTableIndex("460072694054679"));

        //
        // Pattern p = Pattern.compile("^\\+?\\d+$");
        // Matcher m = p.matcher("1256354");
        // System.out.println(m.find());


        // System.out.println("460072694054668".substring(0,3));

       /* String a ="imei=";
        String[] split = a.split("=");


        System.out.println(split[0]);
        System.out.println(split[1]);*/



       /* // 计算成功率
        double successRate = 100.0 * 100 / 254;

        System.out.println(successRate);
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());


        long l = System.currentTimeMillis();
        //创建Instant瞬时对象
        Instant instant = Instant.ofEpochMilli(l);
        //将long毫秒值转为LocalDateTime对象
        // LocalDateTime reqTime = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai"));
        LocalDateTime reqTime = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai"));


        System.out.println(reqTime.getHour());
        System.out.println();*/
    }



    /**
     * 根据userId对1000取余获取对应表索引
     *
     * @param userId
     * @return
     */
    public static String getModTableIndex(String userId) {
        int tableIndex = Math.abs(userId.hashCode()) % 1000;
        return String.format("%03d", tableIndex);
    }
}
