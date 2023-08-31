package cn.ws.tools.gpt;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class Gpt3HttpClient {


    private static boolean proxySet = true;
    private static String proxyHost = "127.0.0.1";
    private static int proxyPort = 7890;


    private static final String API_ENDPOINT = "https://api.openai.com/v1/";

    public static void main(String[] args) throws Exception {
        String apiKey = "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";
        String prompt = "Hello, GPT-3!";
        String model = "text-davinci-002";
        int temperature = 0;
        int maxTokens = 10;
        boolean stopSequences = false;

        // 构建 HTTP 客户端
        CloseableHttpClient client = HttpClients.createDefault();

        // 构建 HTTP 请求
        HttpPost httpPost = new HttpPost(API_ENDPOINT + "engines/" + model + "/completions");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + apiKey);

        // 构建请求体
        String requestBody = "{\"prompt\":\"" + prompt + "\",\"temperature\":" + temperature + ",\"max_tokens\":"
                + maxTokens + ",\"stop\":\"" + (stopSequences ? "\\n" : "") + "\"}";
        httpPost.setEntity(new StringEntity(requestBody, StandardCharsets.UTF_8));

        // 发送请求并获取响应
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String responseText = EntityUtils.toString(entity);

        // 处理响应结果
        System.out.println(responseText);

        // 关闭 HTTP 客户端
        client.close();
    }

    /**
     * POST请求
     *
     * @param url     发送请求的 URL
     * @param param   请求参数 name1=value1&name2=value2 的形式
     * @param isproxy 是否使用代理模式
     * @return 响应结果
     */
    public static String sendPost(String url, String param, boolean isproxy) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = null;
            if (isproxy) {// 使用代理模式
                @SuppressWarnings("static-access")
                Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
                conn = (HttpURLConnection) realUrl.openConnection(proxy);
            }
            else {
                conn = (HttpURLConnection) realUrl.openConnection();
            }

            // https
            if (url.substring(0, 5).equals("https")) {
                SSLContext ctx = MyX509TrustManagerUtils();
                ((HttpsURLConnection) conn).setSSLSocketFactory(ctx.getSocketFactory());
                ((HttpsURLConnection) conn).setHostnameVerifier(new HostnameVerifier() {
                    //在握手期间，如果 URL 的主机名和服务器的标识主机名不匹配，则验证机制可以回调此接口的实现程序来确定是否应该允许此连接。
                    @Override
                    public boolean verify(String arg0, SSLSession arg1) {
                        return true;
                    }
                });
            }

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST"); // POST方法

            // 设置通用的请求属性

            for (Map.Entry<String, String> entry : setProperty().entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
            conn.connect();

            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK
                    || conn.getResponseCode() == HttpURLConnection.HTTP_CREATED
                    || conn.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED) {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            }
            else {
                in = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
            }
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！");
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }



    //设置请求头属性
    public static Map<String, String> setProperty() {
        HashMap<String, String> pMap = new HashMap<>();
        // pMap.put("Accept-Encoding", "gzip"); //请求定义gzip,响应也是压缩包
        pMap.put("connection", "Keep-Alive");
        pMap.put("cookie", "[{\"name\":\"c_user\",\"value\":\"100025453789952\",\"expires\":\"Wed, 29 Jun 2022 17:45:12 GMT\",\"expires_timestamp\":1656524712,\"domain\":\".facebook.com\",\"path\":\"/\",\"secure\":true},{\"name\":\"xs\",\"value\":\"25:XHCn6NBXMtRN2A:2:1624988713:-1:3775\",\"expires\":\"Wed, 29 Jun 2022 17:45:12 GMT\",\"expires_timestamp\":1656524712,\"domain\":\".facebook.com\",\"path\":\"/\",\"secure\":true,\"httponly\":true},{\"name\":\"fr\",\"value\":\"1OzCMdjIXWPZzeWzP.AWWZMz4ICpLfavEQJCaOAB8Qitk.Bg21wo..AAA.0.0.Bg21wo.AWWUj-IuX44\",\"expires\":\"Mon, 27 Sep 2021 17:45:09 GMT\",\"expires_timestamp\":1632764709,\"domain\":\".facebook.com\",\"path\":\"/\",\"secure\":true,\"httponly\":true},{\"name\":\"datr\",\"value\":\"KFzbYE6APv3gX3EK7Tl6TcDM\",\"expires\":\"Thu, 29 Jun 2023 17:45:12 GMT\",\"expires_timestamp\":1688060712,\"domain\":\".facebook.com\",\"path\":\"/\",\"secure\":true,\"httponly\":true}]");
        pMap.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        pMap.put("Content-Type", "application/x-www-form-urlencoded");
        return pMap;
    }


    class MyX509TrustManager extends X509ExtendedTrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // TODO Auto-generated method stub

        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // TODO Auto-generated method stub

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {
            // TODO Auto-generated method stub

        }

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2)
                throws CertificateException {
            // TODO Auto-generated method stub

        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {
            // TODO Auto-generated method stub

        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2)
                throws CertificateException {
            // TODO Auto-generated method stub

        }

    }

    public static SSLContext MyX509TrustManagerUtils() {

        TrustManager[] tm = {new Gpt3HttpClient().new MyX509TrustManager()};
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(null, tm, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctx;
    }

}
