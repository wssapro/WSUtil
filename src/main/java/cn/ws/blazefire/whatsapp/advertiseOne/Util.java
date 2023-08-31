package cn.ws.blazefire.whatsapp.advertiseOne;

import cn.hutool.http.HttpUtil;
import cn.ws.blazefire.whatsapp.WhatsappDlNode;
import cn.ws.tools.ReadLog;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-04-08 17:09
 */
public class Util {

    public static void main(String[] args) {
        String path = "C:\\Users\\Host-424\\Desktop\\2k-token\\";
        List<String> zhenglitoken = zhenglitoken(path);
        // List<String> checkToken = check(zhenglitoken);
        // WriteLog.write(path + "result.txt",checkToken,true);
        // addDlToken(checkToken);
        System.out.println();

    }

    public static List<String> zhenglitoken(String path) {
        List<String> list = ReadLog.readFolder(path);

        List<String> tokenList = new ArrayList<>();
        for (String s : list) {
            String[] split = s.split("\\.");
            String name = split[0];
            String file = path + s;
            List<String> read = ReadLog.read(file);
            if (read.size() > 0) {
                TokenBean tokenBean = JSON.parseObject(read.get(0), TokenBean.class);

                if (tokenBean.getRegistration_jid() == null || "".equals(tokenBean.getRegistration_jid())) {
                    tokenBean.setRegistration_jid(name);
                }

                tokenBean.setPn(name);

                if (tokenBean.getPhoneid_id() == null || "".equals(tokenBean.getPhoneid_id())) {
                    String fdid = UUID.randomUUID().toString();
                    tokenBean.setPhoneid_id(fdid);
                }
                if (tokenBean.getRouting_info() == null || "".equals(tokenBean.getRouting_info())) {
                    tokenBean.setRouting_info("CAgIBQ");
                }
                if (name.startsWith("91")) {
                    tokenBean.setCc("91");
                    tokenBean.setRegion("in");
                }
                else if (name.startsWith("880")) {
                    tokenBean.setCc("880");
                    tokenBean.setRegion("bd");
                }
                WhatsappDlNode whatsappDlNode = new WhatsappDlNode();
                whatsappDlNode.setCountry(tokenBean.getRegion());
                whatsappDlNode.setType(1);
                whatsappDlNode.setPhone(name);
                whatsappDlNode.setToken(new Gson().toJson(tokenBean));
                String json = new Gson().toJson(whatsappDlNode);
                tokenList.add(json);
            }
        }
        return tokenList;
    }

    public static void addDlToken(List<String> whatsappDlNodeList) {
        for (String whatsappDlNode : whatsappDlNodeList) {
            String post = HttpUtil.post("http://fexwhj.qz94.com:10092/udaa/mass/add", whatsappDlNode);
            System.out.println(post);
        }
    }


}
