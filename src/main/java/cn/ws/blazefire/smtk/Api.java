package cn.ws.blazefire.smtk;

import cn.ws.tools.http.HttpClientUtil;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-09-08 11:22
 */
public class Api {
    public static void main(String[] args) {


        String s = HttpClientUtil.doPostJson("http://182.16.50.172:20083/api/phone", "{\"appKey\":\"mKWLOa6f\",\"secretKey\":\"6667938d1488430b9ea8a62c6ee41644\","
                + "\"infos\":[{\"productId\":6,\"abbr\":\"ID\",\"number\":1}]}");


        System.out.println(s);
    }
}
