package cn.ws.study.jdk8.zip;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Demo {
	public static void main(String[] args) {
		//创建出要解压缩的压缩包的文件对象
		File zipFile = new File("C:\\Users\\admin\\Desktop\\新建文件夹 (2)\\AAA.zip");

		String zipFileName = zipFile.getName();
		String targetDirName = zipFileName.substring(0, zipFileName.indexOf("."));
		//创建出目标文件夹
		File targetDir = new File(zipFile.getParent() + "\\" + targetDirName);
		if (!targetDir.exists()) {
			targetDir.mkdir();
		}
		//构造方法传入FIleInputStream对象，并设置字符编码
		try (ZipInputStream in = new ZipInputStream(new FileInputStream(zipFile), Charset.forName("gbk"))) {
			ZipEntry zipEntry = null;
			while ((zipEntry = in.getNextEntry()) != null) {//获取压缩包中的文件对象
				//拿到每个文件对象的文件名
				String zipEntryFileName = zipEntry.getName();
				//拿到要写到的目标文件名，即解压缩后的文件名
				String zipFilePath = targetDir.getPath() + "//" + zipEntryFileName;
				//创建出输出流
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(zipFilePath));
				byte[] buff = new byte[1024];
				int len = -1;
				//开始边读边写
				while ((len = in.read(buff)) != -1) {
					bos.write(buff, 0, len);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
