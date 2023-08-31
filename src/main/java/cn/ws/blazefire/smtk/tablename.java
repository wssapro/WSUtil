package cn.ws.blazefire.smtk;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-08-02 14:37
 */
public class tablename {
    public static void main111(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String tableName = "";
    }

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2023, 7, 1);
        LocalDate endDate = LocalDate.of(2023, 7, 10);

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            System.out.println(currentDate);
            currentDate = currentDate.plusDays(1);
        }
    }
}
