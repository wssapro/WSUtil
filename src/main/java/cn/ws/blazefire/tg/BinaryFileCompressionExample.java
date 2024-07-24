package cn.ws.blazefire.tg;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class BinaryFileCompressionExample {

    public static void main(String[] args) {
        // 假设原始文件路径是您要压缩的文件
        String originalFilePath = "D:\\TGBusiness\\session\\84775872035.session";

        // 读取文件内容
        byte[] fileData = readFileData(originalFilePath);

        // 压缩文件内容并进行 Base64 编码
        String compressedBase64Data = compressAndBase64Encode(fileData);

        System.out.println(compressedBase64Data);

        // 解码和解压缩
        // byte[] decompressedData = base64DecodeAndDecompress(compressedBase64Data);
        // System.out.println("Decompressed Data Length: " + decompressedData.length);

        // 将解压后的数据写入新文件
        // writeToFile("path/to/your/decompressed/file.jpg", decompressedData);
    }

    private static byte[] readFileData(String filePath) {
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }

            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String compressAndBase64Encode(byte[] data) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
                gzipOutputStream.write(data);
            }

            byte[] compressedBytes = outputStream.toByteArray();
            return Base64.getEncoder().encodeToString(compressedBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] base64DecodeAndDecompress(String compressedBase64Data) {
        try {
            byte[] compressedBytes = Base64.getDecoder().decode(compressedBase64Data);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(compressedBytes);
            try (GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream)) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = gzipInputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                return outputStream.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void writeToFile(String filePath, byte[] data) {
        try (OutputStream outputStream = Files.newOutputStream(Paths.get(filePath))) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
