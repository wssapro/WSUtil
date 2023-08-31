package cn.ws.tools.compress;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;

import java.io.*;

public class SevenZUtil {


    /**
     * 压缩多个文件到 7z 文件
     *
     * @param compressFilePath 生成的 7z 文件路径
     * @param inputFiles       多个需要加入压缩的文件，支持文件夹。
     * @return
     */

    public static void compress7z(String compressFilePath, File... inputFiles) throws IOException {
        if (inputFiles.length == 0) {
            throw new RuntimeException("InputFiles is null.");
        }
        for (File inputFile : inputFiles) {
            if (!inputFile.exists()) {
                throw new RuntimeException("InputFile:" + inputFile.getPath() + "not exists.");
            }
        }
        File compressFile = new File(compressFilePath);
        if (compressFile.exists()) {
            throw new RuntimeException("7zFile:" + compressFile.getPath() + "exists.");
        }
        SevenZOutputFile sevenZOutput = new SevenZOutputFile(compressFile);
        try {
            for (File inputFile : inputFiles) {
                compress(sevenZOutput, inputFile, null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sevenZOutput.close();
        }
    }

    private static void compress(SevenZOutputFile sevenZOutput, File inputFile, String name) throws IOException {
        if (name == null) {
            name = inputFile.getName();
        }
        if (inputFile.isDirectory()) { // 目录
            File[] childFiles = inputFile.listFiles();
            if (childFiles.length == 0) {
                SevenZArchiveEntry entry = sevenZOutput.createArchiveEntry(inputFile, name);
                sevenZOutput.putArchiveEntry(entry);
                sevenZOutput.closeArchiveEntry();
            }
            else {
                for (File childFile : childFiles) {
                    compress(sevenZOutput, childFile, name + File.separator + childFile.getName());
                }
            }
        }
        else { // 单个文件
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFile));
            SevenZArchiveEntry entry = sevenZOutput.createArchiveEntry(inputFile, name);
            sevenZOutput.putArchiveEntry(entry);
            int len = -1;
            byte[] buffer = new byte[2048];
            while ((len = inputStream.read(buffer)) != -1) {
                sevenZOutput.write(buffer, 0, len);
            }
            inputStream.close();
            sevenZOutput.closeArchiveEntry();
        }
    }


    public static void sevenZ(String filePath,byte[] zipBytes){

        try {
            File file = new File(filePath);

            SevenZOutputFile sevenZOutput = new SevenZOutputFile(file);

            sevenZOutput.write(zipBytes);
            sevenZOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压 7z 文件
     *
     * @param compressFilePath 7z 文件路径
     * @param outputDir        解压目标目录
     * @return
     */

    public static void unCompress7z(String compressFilePath, String outputDir) throws IOException {
        File compressFile = new File(compressFilePath);
        if (compressFile == null || !compressFile.exists()) {
            throw new RuntimeException("7zFile not exists.");
        }
        File output = new File(outputDir);
        if (output == null || !output.exists() || !output.isDirectory()) {
            throw new RuntimeException("Invalid outputDir:" + outputDir);
        }
        // 循环解压
        SevenZFile sevenZFile = new SevenZFile(compressFile);
        SevenZArchiveEntry entry = null;
        while ((entry = sevenZFile.getNextEntry()) != null) {
            String newFilePath = outputDir + File.separator + entry.getName();
            File newFile = new File(newFilePath);
            // 处理目录
            if (entry.isDirectory()) {
                boolean mkdirs = newFile.mkdirs();
                if (!mkdirs) {
                    throw new RuntimeException("Fail mkdir:" + newFilePath);
                }
                continue;
            }
            // 解压文件
            OutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(newFile);
                int length = 0;
                byte[] buffer = new byte[2048];
                while ((length = sevenZFile.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
            } catch (Exception e) {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            }

        }

    }

}
