package cn.ws.blazefire.uadd;

import java.io.File;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2023-03-17 17:30
 */
public class FileUtil {
    public static void main(String[] args) {
        /*List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a.txt");
        String s = read.get(0);
        JSONObject jsonObject = JSON.parseObject(s);

        JSONArray jsonArray = jsonObject.getJSONArray("response");

        for (Object o : jsonArray) {
            JSONObject object = (JSONObject)o;




        }*/


        // 创建一个File对象来表示目录
        File directory = new File("D:\\TokenJson\\7\\IN");

        // 获取目录下所有文件的文件名
        String[] fileList = directory.list();








    }
}
