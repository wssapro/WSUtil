package cn.ws.tools.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-05-11 19:49
 */
@Data
public class Entity {

    @ExcelProperty("机器id")
    String machineId;
    @ExcelProperty("模拟器名称")
    String emulatorName;
    @ExcelProperty("品牌")
    String model;
    @ExcelProperty("型号")
    String jixing;
    @ExcelProperty("手机号码")
    String phone;
    @ExcelProperty("IMEI")
    String imei;
    @ExcelProperty("IMSI")
    String imsi;
    @ExcelProperty("IP")
    String ip;
    @ExcelProperty("时区")
    String timezone;
    @ExcelProperty("国家")
    String country;
    @ExcelProperty("地区")
    String locale;
    @ExcelProperty("经纬度-GPS")
    Double longitude;
    @ExcelProperty("国家码")
    String countryCode;
}
