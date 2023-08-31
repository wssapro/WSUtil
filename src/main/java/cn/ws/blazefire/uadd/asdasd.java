package cn.ws.blazefire.uadd;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2023-03-20 16:24
 */
public class asdasd {
    public static void main(String[] args) {

        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a.txt");
        List<String> aaa = new ArrayList<>();
        for (String s : read) {
            String noJson = s.replace("no_json_", "");
            aaa.add(noJson);
        }

        WriteLog.write("C:\\Users\\Host-424\\Desktop\\bbbbb.txt",aaa,true);
    }
}
