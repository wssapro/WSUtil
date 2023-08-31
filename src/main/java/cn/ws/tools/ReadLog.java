package cn.ws.tools;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author : Host-424
 * @date Date : 2021-09-06 18:14
 */
public class ReadLog {

    public static List<String> read(String file) {

        List<String> list = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                list.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


    public static List<String> readFolder(String file) {
        List<String> list = new ArrayList<>();
        try {
            File f = new File(file);
            if (f.exists()) {
                File[] fa = f.listFiles();
                if (fa != null && fa.length > 0) {
                    for (File fs : fa) {
                        if (!fs.isDirectory()) {
                            list.add(fs.getName());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<String> readZipLog(String path) {
        List<String> list = new ArrayList<>();
        try {
            ZipFile zipFile = new ZipFile(path);
            InputStream in = new BufferedInputStream(new FileInputStream(path));
            ZipInputStream zin = new ZipInputStream(in);
            ZipEntry ze;
            while ((ze = zin.getNextEntry()) != null) {
                if (!ze.isDirectory()) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(zipFile.getInputStream(ze), StandardCharsets.UTF_8));
                    String line;
                    while ((line = br.readLine()) != null) {
                        list.add(line);
                    }
                    br.close();
                }
            }
            zin.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
