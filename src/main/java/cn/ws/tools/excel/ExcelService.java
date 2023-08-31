package cn.ws.tools.excel;

import com.alibaba.excel.EasyExcel;

import java.util.List;
import java.util.Map;

/**
 * 表格解析
 *
 * @date Date : 2022-05-26 22:11
 */
public class ExcelService {


    public static void main(String[] args) {


        List<Map<Integer, String>> maps = readExcel("C:\\Users\\Host-424\\Desktop\\1682424152158模拟器数据.xlsx", 0, 1);
        for (Map<Integer, String> map : maps) {

            System.out.println(map.get(0)
                    + "###" + map.get(1)+ "###" + map.get(2)
                    + "###" + map.get(3)+ "###" + map.get(4)
                    + "###" + map.get(5)+ "###" + map.get(6)
                    + "###" + map.get(7)
            );
        }

    }

    public static void writeExcel(String file, int sheet, int headRowNumber) {

    }


    public static List<Map<Integer, String>> readExcel(String file, int sheet, int headRowNumber) {
        return EasyExcel
                .read(file)
                .sheet(sheet)
                .headRowNumber(headRowNumber)
                .doReadSync();


    }


}
