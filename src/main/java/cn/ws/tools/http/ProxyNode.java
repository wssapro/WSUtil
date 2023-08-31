package cn.ws.tools.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.Proxy;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-04-25 15:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProxyNode {

    private Proxy.Type proxyType = Proxy.Type.SOCKS;

    public ProxyNode(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public ProxyNode(String host, Integer port, String account, String password) {
        this.host = host;
        this.port = port;
        this.account = account;
        this.password = password;
    }

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



}
