package cn.ws.blazefire.ip;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * compile 'com.squareup.okhttp3:okhttp:3.10.0'
 */
class ApiProxyJava {
    public static void main(String[] args) throws IOException {
        // testHttpWithOkHttp();
        // testSocks5WithOkHttp();
        testHttp();
    }

    public static void testHttpWithOkHttp() throws IOException {
        String url = "http://ip123.in/ip.json";
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("159.138.34.194", 15003));
        OkHttpClient client = new OkHttpClient().newBuilder().proxy(proxy).build();

        Request request = new Request.Builder().url(url).build();
        okhttp3.Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        System.out.println(responseString);
    }

    public static void testSocks5WithOkHttp() throws IOException {
        String url = "http://ip123.in/ip.json";
        Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("119.8.51.125", 15004));
        OkHttpClient client = new OkHttpClient().newBuilder().proxy(proxy).build();

        Request request = new Request.Builder().url(url).build();
        okhttp3.Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        System.out.println(responseString);
    }


    public static void testHttp() throws IOException {
        String url = "http://ip123.in/ip.json";
        String responseString = doGet(url);
        System.out.println(responseString);
    }


    /**
     * 利用HttpClient进行get请求
     *
     * @param url
     * @return
     */
    public static String doGet(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            httpGet = new HttpGet(url);

            HttpHost httpHost = new HttpHost("159.138.34.194",15003);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setProxy(httpHost).build();
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "utf-8");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
