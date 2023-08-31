package cn.ws.tools.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * ZIP数据流处理
 */
public class ZipTool
{
	/**
	 * 压缩字节流数据 ESET-NOD32
	 *
	 * @param data 传入需要压缩的字节数组
	 * @return 压缩的数据
	 * @throws IOException
	 */
	public static byte[] zipBytes(byte[] data)
	{
		if (data == null || data.length == 0)
		{
			return null;
		}

		byte[] b = null;
		try
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(bos);
			gzip.write(data);
			gzip.finish();
			gzip.close();
			b = bos.toByteArray();
			bos.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return b;
	}

	/**
	 * 解压数据流 ESET-NOD32
	 *
	 * @param data 传入数据流
	 * @return 解压的数流
	 * @throws IOException
	 */
	public static byte[] unzipBytes(byte[] data)
	{
		if (data == null || data.length == 0)
		{
			return null;
		}

		byte[] b = null;
		try
		{
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
			GZIPInputStream gzip = new GZIPInputStream(bis);
			byte[] buf = new byte[1024];
			int num = -1;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((num = gzip.read(buf, 0, buf.length)) != -1)
			{
				baos.write(buf, 0, num);
			}
			b = baos.toByteArray();
			baos.flush();
			baos.close();
			gzip.close();
			bis.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return b;
	}
}
