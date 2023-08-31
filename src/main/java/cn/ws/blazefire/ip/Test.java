package cn.ws.blazefire.ip;

import cn.ws.blazefire.ip.bf.AddrReq;
import cn.ws.blazefire.ip.bf.AddrResp;
import cn.ws.tools.http.HttpClientUtil;
import com.alibaba.fastjson.JSON;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-07-18 15:00
 */
public class Test {
    public static void main(String[] args) {


        System.out.println(29/20);
    }




    public void sss(){
        AddrReq addrReq = new AddrReq();

        addrReq.setUserKey("81411558-5fec-4610-9391-b38d94bdb45e");
        addrReq.setShortCountry("IN");
        addrReq.setNumber(1);
        String s = HttpClientUtil.doPostJson("http://182.16.50.172:32001/IPServer/addr", JSON.toJSONString(addrReq));

        AddrResp addrResp = JSON.parseObject(s,AddrResp.class);
        System.out.println(s);
    }
}
