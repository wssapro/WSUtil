package cn.ws.blazefire.ip;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-08-09 16:32
 */
public class IpTest {
    private final static String REFRESH_IP_URL = "http://rose-ip.com/RefreshIP?userName=%s&countryISO=%s";
    // private final static String REFRESH_IP_URL = "";

    public static void main(String[] args) throws Exception {
        // 子账户
        // reflush("51301322_1","in");
        use("51301322_1");



    }

    public static void reflush(String userName,String country) throws Exception{
        //刷新IP
        long l = System.currentTimeMillis();
        OkHttpClient client1 = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        Request request1 = new okhttp3.Request.Builder()
                .url(String.format(REFRESH_IP_URL,userName,country))
                .build();
        Response execute = client1.newCall(request1).execute();

        System.out.println(System.currentTimeMillis() - l);
        System.out.println("rsp-->"+execute.body().string());
    }

    public static void use(String userName) throws Exception{
        // 代理账户密码
        String pwd = "31499265";
        // 代理服务地址
        String host = "cn.rose-ip.com";
        // 代理服务端口
        int port = 20225;
        //使用代理
        java.net.Authenticator.setDefault(new Authenticator() {
            private final PasswordAuthentication authentication = new PasswordAuthentication(userName, pwd.toCharArray());
            protected PasswordAuthentication getPasswordAuthentication() {
                return authentication;
            }
        });
        Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(host, port));
        OkHttpClient client2 = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .proxy(proxy)
                .build();
        String url = "https://api.drncloud.com/out/ext_api/getMsg?"
                + "name=llwshz001"
                + "&pwd=llwshz001"
                + "&ApiKey=bmJrZ1VJdHA1VjhnSHNzZURmWDA4QT09"
                + "&pn=+393887879307"
                + "&pid=0257"
                + "&serial=2";
        Request request = new Request.Builder()
                // .url("http://ip123.in/ip.json")
                .url(url)
                .build();
        Response response = null;
        try {
            response = client2.newCall(request).execute();
            String string = response.body().string();
            response.body().close();
            System.out.println("rsp-->"+string);
        } catch (IOException e) {
            System.err.println("Failed scraping");
            e.printStackTrace();
        }
    }
}
