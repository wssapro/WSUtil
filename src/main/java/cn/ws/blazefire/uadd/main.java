package cn.ws.blazefire.uadd;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-10-28 10:09
 */
public class main {
    public static void main(String[] args) throws Exception {
        // 每日整理数据
        /*long oneDay = 24 * 60 * 60 * 1000;

        long initDelay = getTimeMillis("3:00:00") - System.currentTimeMillis();

        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

        System.out.println(initDelay);*/


        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

        Date format = dateFormat.parse("21-11-04 02:00:00");
        System.out.println(sale(System.currentTimeMillis() - format.getTime()));
    }

    private static long getTimeMillis(String time) {
        try {

            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (Exception e) {

            e.printStackTrace();

        }
        return 0;
    }


    public static long sale(long diff) {
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long day = diff / nd;// 计算差多少天
        return diff % nd / nh + day * 24;// 计算差多少小时
    }
}
