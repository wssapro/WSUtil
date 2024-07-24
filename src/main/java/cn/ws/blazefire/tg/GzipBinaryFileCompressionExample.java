package cn.ws.blazefire.tg;

import java.io.*;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipBinaryFileCompressionExample {

    public static void main(String[] args) throws IOException {
        // 假设原始文件路径是您要压缩的文件
        String originalFilePath = "D:\\TGBusiness\\session\\84775872035.session";

        // 读取文件内容
        byte[] fileData = readFileData(originalFilePath);
        String compressedBase64Data = compressAndBase64Encode(fileData);
        System.out.println(compressedBase64Data);

        compressedBase64Data = "H4sIAFxI4GUC_-3cfWwTZRwH8OdufdlLu6IkNMvcfCaBtlBmx9I5EiFjOBZkiaIoEyPnbXdbb_T17jrWgS9s-wNIBv8YlmCCcUiiRifBGBR8R8GExNQ4SUwgcQacy_CFBF3MJni9rWnnulYTYuLy_eS6e_rcr8-e-_bpH8-S7tEtTZIq0raQHOBVWk0WEYYhdZQSQrZpDzNJMWoPQ9pzhuS2jVR2xK3WXcRUxBDbyeLj1ucsJmt90T95LQAAAADA7dfDmsz2ZcuY3kaVb_GL0bDAqyKnqNrP9LZ5wyMN67c20K3r65saaPoV6iykGUgClYKq2C7KNCxLAV6O0Z1izJ2xNqwqyeLMBZFcBYnpZK9QxEiyYM51V88ag9leUcH0rdVDUMSgyrVJWiPVMs4KINU_z-0HBC8nSO2iotIWf6gl85wSA3CK1J1j6mosnKMiFXbm6z5e8WWvSHuPnKm5u1NTdOvTcM3NrtposjdWMEQKCmKXEvFr2ymOj6oh_TmXCoqrSrVN2sLL11ff0jyzvayM6SvRg9cKJFXS89fPhlmhJ3tvw4pLD4QGQyoNRv3-zKVRRZSDfECkqtilzhOeLxTM8Q7lGCF9_WZYnoWsnlJv-8zyVBQpFFSS57y_Lc3p3nlSElq5fxOUdvOdoszxgiBr42bLICSr2SPQFoWP035Rlg-Eyu8UQ1E1bYZzw2hiTPbSUiaiR6HNLXGzMyd2VhAzndSZbGS4aZc1sZG3TRHtAAAAAAAAAIAFiDWzRN__F48S7QAAAAAAAAD4v-tZYjQTB9tnIWuqKqs8tZXemsrVHg9z5sBDRVebXri14mzr-WfDRme5_ZJ6ILjqvvHSF03797kijteG8jpPvmr9akftiXX5T4ZqO5f3LqFFhzYMWN6JjJRIh0eFlUO7C_o7Xik5dao_dkwY4L_ZODZWf8N388LPV1rXlh3sidiOWlZ4HnjY6y2vD3_57bHTDa2rai66Jqf2Hhl6-dav739arnzEDgYm9t176M7BMXGw-fvG-Gb3M5P02ueHHYM_Xo8Pv9VoO_7UjZXv3vUdf_TpP79-3F3gHPmt7qX9I9vP7D134veL61w3X99kmJh60_tGcWHF25_tGPZsrjk4sfraPYa7L9P3nvgi_svGn7af7Tpt2TJuvxrt3_1Y3ScfNp_v-Dg-_kdi_8_aholt2Ia_AAAAAAAAAAD896oHrvRfIGZichgdhg7OeP_kpQfrpFh7m9zGdbXskrtVsviDguVLN-ldtFnvEi_v-eEO7UXTX9Zn9vSKz2tdo4uTYyW6k2MlLiT2_2QRwgYAAAAAAABYyAqx_wcAAAAAAABY8Kb__991oh0AAAAAAAAAsHA2_CbC5BvY7sQ3BdhzfwEFbLCFAHAAAA";
        // 解码和解压缩
        byte[] decompressedData = base64DecodeAndDecompress(compressedBase64Data);
        // 将解压后的数据写入新文件
        writeToFile("D:\\TGBusiness\\session_zip\\84775872035.session", decompressedData);
    }

    private static byte[] readFileData(String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
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

            return Base64.getUrlEncoder().encodeToString(compressedBytes).replaceAll("=","");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] base64DecodeAndDecompress(String compressedBase64Data) {
        try {
            byte[] compressedBytes = Base64.getUrlDecoder().decode(compressedBase64Data);
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
        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
