package cn.ws.blazefire.td;

import cn.ws.tools.http.HttpClientUtil;
import com.alibaba.fastjson.JSON;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-11-28 20:06
 */
public class JM {
    public static void main(String[] args) {


        String json = "{\"date\":\"2022112815\",\"getPhone\":true,\"cc\":\"91\",\"msg\":\"{\\\"autoconf_type\\\":1,\\\"email_wait\\\":0,\\\"guess_wait\\\":0,\\\"guesses_left\\\":15,\\\"login\\\":\\\"917073561575\\\",\\\"min_poll\\\":5,\\\"reason\\\":\\\"security_code\\\",\\\"server_time\\\":1669619015,\\\"status\\\":\\\"fail\\\",\\\"wipe_token\\\":\\\"1669619015\\\",\\\"wipe_type\\\":\\\"offline\\\",\\\"wipe_wait\\\":0}\\n\",\"country\":\"IN\",\"cd\":\"10001000\",\"getCodeTimes\":1,\"code\":\"786439\",\"sendCode\":true,\"configJo\":\"Hide\",\"sendCodeTime\":\"2022-11-28 15:03:23\",\"getCodeTime\":\"2022-11-28 15:03:33\",\"jmId\":7,\"timeStamp\":1669619016662,\"phone\":\"917073561575\",\"registerNum\":\"three\",\"getPhoneTime\":\"2022-11-28 15:02:51\",\"device\":\"1000\",\"getCode\":true,\"register\":false}";

        RegisterStatistics registerStatistics = JSON.parseObject(json, RegisterStatistics.class);

        registerStatistics.setType(0);

        String s = HttpClientUtil.doPostJson("http://192.168.1.97:19900/AnalysisLog/Interface/tdLog", JSON.toJSONString(registerStatistics));


        System.out.println(s);


    }
}
