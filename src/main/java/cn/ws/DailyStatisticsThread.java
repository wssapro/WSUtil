package cn.ws;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import cn.ws.tools.http.HttpClientUtil;
import cn.ws.tools.http.HttpClientUtils;
import cn.ws.tools.http.ProxyNode;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 每日统计
 *
 * @author : Host-424
 * @date Date : 2021-10-22 11:48
 */
public class DailyStatisticsThread {

    /**
     * 本地通过ip获取对应ip数据接口(勿删，重要)
     */
    public static void main(String[] args) {
        ProxyNode proxy = new ProxyNode();
        proxy.setHost("127.0.0.1");
        proxy.setPort(7890);

        // proxy = getProxy("IN");

        List<String> list = new ArrayList<>();
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a.txt");
        for (int i = 0; i < read.size(); i++) {
            try {
                String s = read.get(i);
                String[] split = s.split("###");
                String ip = split[5];
                String url = "https://ipapi.co/" + ip + "/json/";
                JSONObject jsonObject1 = HttpClientUtils.doGet(url, proxy, null, 5000);
                String result = jsonObject1.getString("result");
                JSONObject jsonObject = JSONObject.parseObject(result);
                String languages = "en";
                String timezone = jsonObject.getString("timezone");
                String country = jsonObject.getString("country");
                String locale = jsonObject.getString("languages").split(",")[0];
                String longitudelatitude = jsonObject.getDouble("longitude") + "," + jsonObject.getDouble("latitude");
                String countryCode = jsonObject.getString("country_calling_code").replace("+", "");

                list.add(s + "###" + languages + "###" + timezone + "###" + country + "###" + locale + "###" + longitudelatitude + "###" + countryCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\c.txt", list, true);

    }


    public static ProxyNode getProxy(String country) {
        String proxyUrl = "http://148.66.6.138:20081/IPCenterCtrl/proxy";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("businessId", "5");
        jsonObject.put("country", country);
        String response = HttpClientUtil.doPostJson(proxyUrl, jsonObject.toJSONString());
        JSONObject proxyGet = JSONObject.parseObject(response);
        JSONObject json = proxyGet.getJSONObject("proxyNode");
        return JSONObject.parseObject(json.toJSONString(), ProxyNode.class);
    }
}
