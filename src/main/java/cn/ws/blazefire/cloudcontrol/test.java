package cn.ws.blazefire.cloudcontrol;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2023-03-23 17:28
 */
public class test {
    public static void main(String[] args) {


        List<String> read = ReadLog.read("D:\\Desktop\\novel\\tunshixingkong.txt");

        List<String> asdas = new ArrayList<>();
        for (String s : read) {
            if (!StringUtils.isEmpty(s)) {

                String t = s.replace(" ","");
                while (t.length() > 50){
                    String t1 = t.substring(0, 50);
                    t = t.substring(50);
                    asdas.add(t1);
                }
                asdas.add(t);


            }
        }
        WriteLog.write("D:\\Desktop\\novel\\tunshixingkong2.txt", asdas, true);
    }
}
