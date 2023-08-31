package cn.ws.blazefire.ip;

import lombok.Data;

/**
 * @author : Host-424
 * @date Date : 2022-07-21 11:22
 */
@Data
public class ProxyNode {

    /**
     * ip
     */
    private String address;

    /**
     * 代理开始时间
     */
    private Long startTime;

    /**
     * 返回开始时间
     */
    private Long returnTime;

    /**
     * 使用次数
     */
    private int useTimes;

    /**
     * 是否需要密码
     */
    private Integer isPwd;
    /**
     * 地址
     */
    private String host;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;

    public void addUseTimes() {
        this.useTimes++;
    }
}
