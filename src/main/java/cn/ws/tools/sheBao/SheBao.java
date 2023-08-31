package cn.ws.tools.sheBao;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-02-28 16:15
 */
public class SheBao {
    public static void main(String[] args) {

        for (int i = 15000; i <= 30000; i+=1000) {
            String result = doGet(i);

            SheBaoBean sheBaoBean = JSON.parseObject(result, SheBaoBean.class);

            System.out.println(i + ":" + sheBaoBean.getFinal_salary());
        }

    }


    public static String doGet(double base){
        String url = "http://salarycalculator.sinaapp.com/calculate"
                + "?"
                + "city=shanghai"
                + "&origin_salary="+base
                + "&base_3j="+base
                + "&base_gjj="+base
                + "&is_gjj=true"
                + "&is_exgjj=false"
                + "&factor_exgjj=0.08";
        return HttpUtil.get(url);
    }
}
