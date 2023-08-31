package cn.ws.blazefire.whatsapp.test;

import cn.ws.blazefire.whatsapp.CheckTokenUtil;
import cn.ws.tools.base64.AndroidBase64;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.whatsapp.ObjectUtil;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-07-29 14:08
 */
public class MeTest {
    public static void main(String[] args) {
        String me = "rO0ABXNyAA9jb20ud2hhdHNhcHAuTWXk6K3RrOBlqgIAA0wAAmNjdAASTGphdmEvbGFuZy9TdHJpbmc7TAAJamFiYmVyX2lkcQB"
                + "-AAFMAAZudW1iZXJxAH4AAXhwdAACNTV0AAw1NTczODE0Njc1MTV0AAs3Mzk4MTQ2NzUxNQ";
        byte[] buf = AndroidBase64.decode(me, CheckTokenUtil.BASE64_FLAG);

        Object o = ObjectUtil.readObjectByteArray(buf);

        JsonObject asJsonObject = JsonParser.parseString(new Gson().toJson(o)).getAsJsonObject();


        System.out.println(new Gson().toJson(o));
    }
}
