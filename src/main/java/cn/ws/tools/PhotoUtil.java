package cn.ws.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-10-12 15:17
 */
public class PhotoUtil {


    public static void main(String[] args) throws Exception {
        String url = "http://h2qoxbg.wdbaodi.com/ws/head/";
        for (int i = 227; i <= 1000; i++) {
            download(url + i + ".jpg",i);
        }
    }


    //java 通过url下载图片保存到本地
    public static void download(String urlString, int i) throws Exception {
        try {
            // 构造URL
            URL url = new URL(urlString);
            // 打开连接
            URLConnection con = url.openConnection();
            // 输入流
            InputStream is = con.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            String filename = "D:\\TdLogicFile\\TdLogicPhoto\\" + i + ".jpg";  //下载路径及下载图片名称
            File file = new File(filename);
            FileOutputStream os = new FileOutputStream(file, true);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            System.out.println(i);
            // 完毕，关闭所有链接
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
