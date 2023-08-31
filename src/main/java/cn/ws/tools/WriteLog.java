package cn.ws.tools;

import java.io.*;
import java.util.List;

/**
 * @author : Host-424
 * @date Date : 2021-09-06 18:14
 */
public class WriteLog {

    public static void main(String[] args) {
        create("C:\\Users\\Host-424\\Desktop\\aaa.txt");
        write("C:\\Users\\Host-424\\Desktop\\aaa.txt","3",true);
    }

    public void method1() {
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f=new File("E:\\personalitydic.txt");
            //true,进行追加写。
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println("chapter401");
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void create(String path){
        try {
            File file=new File(path);
            if(!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String path ,String msg,boolean append) {
        try {
            create(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(path,append));
            bw.append(msg);
            bw.newLine(); //换行用
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String path , List<String> list,boolean append) {
        try {
            create(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(path,append));
            for (String s : list) {
                bw.write(s);
                bw.newLine(); //换行用
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(FileWriter fileWriter,String msg) {
        try {
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(msg);
            bw.newLine(); //换行用
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(BufferedWriter bw,String msg) {
        try {
            bw.write(msg);
            bw.newLine(); //换行用
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
