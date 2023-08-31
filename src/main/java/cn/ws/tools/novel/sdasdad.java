package cn.ws.tools.novel;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2023-03-19 16:24
 */
public class sdasdad {
    public static void main(String[] args) {

        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\aaa.txt");

        List<String> aa  = new ArrayList<>();
        for (String s : read) {
            String[] split = s.split("。");
            for (String s1 : split) {
                aa.add(s1);
            }
        }
        WriteLog.write("C:\\Users\\Host-424\\Desktop\\qweqwe.txt",aa,true);
    }
}
