/**
 * Copyright 2022 bejson.com
 */
package cn.ws.blazefire.td;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterStatistics {

    // 类型：0-注册、1-养号
    private int type;

    // 时间（年月日时：2022112817）
    private String date;
    // 手机号
    private String phone;
    // 国家码
    private String cc;
    // 国家
    private String country;
    // 渠道机型
    private String cd;
    // 机型
    private String device;

    private int jmId = 11;

    // 注册返回原因
    private String msg;

    // 获取手机号
    private boolean getPhone;
    private Date getPhoneTime;
    // 发送验证码
    private boolean sendCode;
    private Date sendCodeTime;
    // 获取验证码
    private boolean getCode;
    private Date getCodeTime;
    private String code;
    private int getCodeTimes;
    // 注册
    private boolean register;
    private Date registerTime;
}
