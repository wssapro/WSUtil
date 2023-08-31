package cn.ws.tools.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.function.Consumer;

/**
 * <p>
 * http请求工具类
 * </p>
 *
 * @author shun
 * @since 2020-01-06
 */
public class HttpClientUtils {

    public static void main(String[] args) {
        String url = "https://client-s.gateway.messenger.live.com/v1/users/ME/properties";

        ProxyNode proxyNode = new ProxyNode("148.66.17.4", 11081,"user7030","zhcghsux");
        // ProxyNode proxyNode = new ProxyNode("192.168.1.9", 1080);
        /*String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjEwNiIsIng1dCI6Im9QMWFxQnlfR3hZU3pSaXhuQ25zdE5PU2p2cyIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2ODI1MDE3NTUsImV4cCI6MTY4MjU4ODE1Mywic2t5cGVpZCI6ImxpdmU6LmNpZC5hMjI5NjE0ZTc0ZWRhOGE2Iiwic2NwIjo5NTgsImNzaSI6IjE2ODI1MDE3NTMiLCJjaWQiOiJhMjI5NjE0ZTc0ZWRhOGE2IiwiYWF0IjoxNjgyNTAxNzQxfQ.otNKfja4ijD1fbKtd2k6XDPAFPeyeoi9M_LYyeQtkJCCt4g44wbHTb34SYU1pUY28lMCLQXHF4egI1XHVUu0kJTJu1i6E2chB8FlL-6-3JQ3Pzb0H9fsXL3v7JfnQExhCkxooNeij8NLQ02TT_Z4P7Co_68idOkZRRdolWK9DfVUVaHgvBjRd1Y7qdKC6QfsSoMAodEisxaWXKx7ZpkKZ285jaBcSvDqBqHvVctMLubUP0eibBTtCnfIjTSGd6ylwt1Mk_1DD7b1lvqDm5o_clgLMe-990hmLAipWRA58tHyRgcp4perYn3WArRSacmtYw9rhd742j_X0hS1BgFdHw";
        JSONObject jsonObject = HttpClientUtils.doGet(url,proxyNode , httpRequestBase -> {
            httpRequestBase.addHeader("Content-Type", "application/json");
            httpRequestBase.addHeader("Authentication", "skypetoken=" + token);
        }, 60000, true);*/

        JSONObject jsonObject = HttpClientUtils.doGet("http://ip234.in/ip.json", proxyNode, null, 6000);

        System.out.println(jsonObject.toJSONString());
    }
    public static void doOptions(String url, ProxyNode proxyNode, Consumer<HttpRequestBase> headers, int timeout) {
        HttpOptions httpOptions = new HttpOptions(url);
        doEx(httpOptions, proxyNode, headers, timeout);
    }

    public static JSONObject doGet(String url, ProxyNode proxyNode, Consumer<HttpRequestBase> headers, int timeout) {
        return doGet(url, proxyNode, headers, timeout, false);
    }

    public static JSONObject doGet(String url, ProxyNode proxyNode, Consumer<HttpRequestBase> headers, int timeout, boolean resHeaders) {
        HttpGet httpGet = new HttpGet(url);
        return doEx(httpGet, proxyNode, headers, timeout, resHeaders);
    }


    public static JSONObject doPost(String url, ProxyNode proxyNode, String json, Consumer<HttpRequestBase> headers, int timeout) {
        HttpPost httpPost = new HttpPost(url);
        return doExEntity(httpPost, proxyNode, json, headers, timeout);
    }

    public static JSONObject doPut(String url, ProxyNode proxyNode, String json, Consumer<HttpRequestBase> headers, int timeout) {
        HttpPut httpPut = new HttpPut(url);
        return doExEntity(httpPut, proxyNode, json, headers, timeout);
    }

    /**
     * 不带请求体
     *
     * @param httpRequestBase
     * @param proxyNode
     * @param headers
     * @param timeout
     * @return
     */
    private static JSONObject doEx(HttpRequestBase httpRequestBase, ProxyNode proxyNode, Consumer<HttpRequestBase> headers, int timeout) {
        return doEx(httpRequestBase, proxyNode, headers, timeout, false);
    }

    private static JSONObject doEx(HttpRequestBase httpRequestBase, ProxyNode proxyNode, Consumer<HttpRequestBase> headers, int timeout, boolean resHeaders) {
        JSONObject jsonObject = new JSONObject();
        CloseableHttpClient httpClient = getHttpclient();
        if (httpClient == null) {
            return null;
        }
        CloseableHttpResponse response = null;
        try {

            // 设置请求参数和头信息
            setConfig(httpRequestBase, headers, timeout);

            // 设置代理
            HttpClientContext context = setProxy(proxyNode);

            // 执行请求
            response = httpClient.execute(httpRequestBase, context);

            jsonObject = getReaponse(response, resHeaders);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonObject;
    }

    /**
     * @param httpRequestBase
     * @param proxyNode
     * @param json
     * @param headers
     * @param timeout
     * @return
     */
    private static JSONObject doExEntity(HttpEntityEnclosingRequestBase httpRequestBase, ProxyNode proxyNode, String json, Consumer<HttpRequestBase> headers, int timeout) {
        return doExEntity(httpRequestBase, proxyNode, json, headers, timeout, false);
    }

    private static JSONObject doExEntity(HttpEntityEnclosingRequestBase httpRequestBase, ProxyNode proxyNode, String json, Consumer<HttpRequestBase> headers, int timeout, boolean resHeaders) {
        JSONObject jsonObject = null;
        CloseableHttpClient httpClient = getHttpclient();
        if (httpClient == null) {
            return null;
        }
        CloseableHttpResponse response = null;
        try {
            if (json != null) {
                StringEntity entity = new StringEntity(json);
                httpRequestBase.setEntity(entity);
            }

            // 设置请求参数和头信息
            setConfig(httpRequestBase, headers, timeout);

            // 设置代理
            HttpClientContext context = setProxy(proxyNode);

            // 执行请求
            response = httpClient.execute(httpRequestBase, context);

            jsonObject = getReaponse(response, resHeaders);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonObject;
    }

    /**
     * 从response获取数据
     *
     * @param response
     * @return
     */
    private static JSONObject getReaponse(CloseableHttpResponse response, boolean resHeaders) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (response == null) {
                return jsonObject;
            }

            // 获取状态码
            JSONObject statusLineJson = new JSONObject();
            statusLineJson.put("code", response.getStatusLine().getStatusCode());
            statusLineJson.put("reason", response.getStatusLine().getReasonPhrase());
            jsonObject.put("statusLineJson", statusLineJson);


            // 获取相应头信息
            if (resHeaders) {
                JSONObject headerJson = new JSONObject();
                Header[] allHeaders = response.getAllHeaders();
                for (Header header : allHeaders) {
                    headerJson.put(header.getName(), header.getValue());
                }
                jsonObject.put("allHeaders", headerJson);
            }


            // 获取相应内容
            jsonObject.put("result", EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 设置请求参数和头信息
     *
     * @param httpRequestBase
     * @param headers
     * @param timeout
     */
    private static void setConfig(HttpRequestBase httpRequestBase, Consumer<HttpRequestBase> headers, int timeout) {
        try {
            httpRequestBase.setConfig(RequestConfig.custom()
                    .setConnectTimeout(timeout == 0 ? 3000 : timeout)
                    .build());

            if (headers != null) {
                headers.accept(httpRequestBase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置代理
     *
     * @param proxyNode
     * @return
     */
    private static HttpClientContext setProxy(ProxyNode proxyNode) {
        HttpClientContext context = HttpClientContext.create();
        if (proxyNode != null) {
            InetSocketAddress socksaddr = new InetSocketAddress(proxyNode.getHost(), proxyNode.getPort());
            context.setAttribute("socks.address", socksaddr);
            context.setAttribute("proxy.Type", proxyNode.getProxyType());

            if (proxyNode.getAccount() != null) {
                Authenticator.setDefault(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(proxyNode.getAccount(), proxyNode.getPassword().toCharArray());
                    }
                });
            }
        }
        return context;
    }

    /**
     * 获取http连接
     *
     * @return
     */
    private static CloseableHttpClient getHttpclient() {
        SSLContext sslContext = createSSLContext();
        if (sslContext != null) {

            Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", new MyConnectionSocketFactory())
                    .register("https", new MySSLConnectionSocketFactory(sslContext))
                    .build();
            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(reg);

            return HttpClients.custom()
                    .setConnectionManager(cm)
                    .build();
        }
        return null;
    }

    private static SSLContext createSSLContext() {

        try {
            SSLContext ctx = SSLContext.getInstance("TLSv1.2");
            X509TrustManager tm = new X509TrustManager() {

                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            return ctx;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static class MyConnectionSocketFactory extends PlainConnectionSocketFactory {
        @Override
        public Socket createSocket(final HttpContext context) {
            InetSocketAddress socksaddr = (InetSocketAddress) context.getAttribute("socks.address");
            if (socksaddr == null) {
                return new Socket();
            }
            Proxy.Type type = (Proxy.Type) context.getAttribute("proxy.Type");
            Proxy proxy = new Proxy(type, socksaddr);
            return new Socket(proxy);
        }

        @Override
        public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress,
                                    InetSocketAddress localAddress, HttpContext context) throws IOException {
            // Convert address to unresolved
            InetSocketAddress unresolvedRemote = InetSocketAddress
                    .createUnresolved(host.getHostName(), remoteAddress.getPort());
            return super.connectSocket(connectTimeout, socket, host, unresolvedRemote, localAddress, context);
        }
    }

    static class MySSLConnectionSocketFactory extends SSLConnectionSocketFactory {

        public MySSLConnectionSocketFactory(final SSLContext sslContext) {
            // You may need this verifier if target site's certificate is not secure
            super(sslContext, new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}, null, ALLOW_ALL_HOSTNAME_VERIFIER);
        }

        @Override
        public Socket createSocket(final HttpContext context) {
            InetSocketAddress socksaddr = (InetSocketAddress) context.getAttribute("socks.address");
            if (socksaddr == null) {
                return new Socket();
            }
            Proxy.Type type = (Proxy.Type) context.getAttribute("proxy.Type");
            Proxy proxy = new Proxy(type, socksaddr);
            return new Socket(proxy);
        }

        @Override
        public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress,
                                    InetSocketAddress localAddress, HttpContext context) throws IOException {
            // Convert address to unresolved
            InetSocketAddress unresolvedRemote = InetSocketAddress
                    .createUnresolved(host.getHostName(), remoteAddress.getPort());
            return super.connectSocket(connectTimeout, socket, host, unresolvedRemote, localAddress, context);
        }
    }
}
