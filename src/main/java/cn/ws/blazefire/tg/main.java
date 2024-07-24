package cn.ws.blazefire.tg;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import cn.ws.tools.http.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.formula.functions.T;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-12-05 17:19
 */
public class main {
    public static void main(String[] args) {
        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a.txt");
        for (String json : read) {
            try {
                String s = HttpClientUtil.doPostJson("http://148.66.21.91:20101/TokenCentre/token/tokenReport", json);
                WriteLog.write("C:\\Users\\Host-424\\Desktop\\b.txt",s,true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
