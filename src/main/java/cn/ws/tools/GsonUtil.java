package cn.ws.tools;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-10-21 17:55
 */
public class GsonUtil {

    public static void main(String[] args) {

    }

    public static String toJsonString(Object object) {
        try {
            return new Gson().toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象
     *
     * @param jsonData JSON数据
     * @param clazz    指定的java对象
     * @return 指定的java对象
     */
    public static <T> T getJsonToBean(String jsonData, Class<T> clazz) {
        try {
            return new Gson().fromJson(jsonData, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象
     *
     * @param jsonString JSON数据
     * @return 指定的java对象
     */
    public static JsonObject getJsonObject(String jsonString) {
        try {
            return JsonParser.parseString(jsonString).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
