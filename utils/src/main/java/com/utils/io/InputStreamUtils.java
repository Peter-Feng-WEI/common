package com.utils.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 流的处理工具类
 * 
 * Created by feng.wei on 20170815.
 *
 */
public class InputStreamUtils {

	/**
	 * InputStream转换成Byte 注意:流关闭需要自行处理
	 * 
	 * @param in
	 * @return byte
	 * @throws Exception
	 */
	public static byte[] InputStreamTOByte(InputStream in) throws IOException {

		int BUFFER_SIZE = 4096;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;

		while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);

		data = null;
		byte[] outByte = outStream.toByteArray();
		outStream.close();

		return outByte;
	}

	/**
	 * InputStream转换成String 注意:流关闭需要自行处理
	 * 
	 * @param in
	 * @param encoding
	 *            编码
	 * @return String
	 * @throws Exception
	 */
	public static String InputStreamTOString(InputStream in, String encoding) throws IOException {

		return new String(InputStreamTOByte(in), encoding);

	}
	
	/**
	 * Description: 判断云服务文件上传时文件的contentType
	 * 
	 * @Version1.0
	 * 
	 * @param FilenameExtension
	 *            文件后缀
	 * @return String
	 */
	public static  String contentType(String FilenameExtension) {
		
		if (FilenameExtension==null)FilenameExtension="";//防止此对象为null
		
		if (FilenameExtension.equals("BMP") || FilenameExtension.equals("bmp")) {
			return "image/bmp";
		}
		if (FilenameExtension.equals("GIF") || FilenameExtension.equals("gif")) {
			return "image/gif";
		}
		if (FilenameExtension.equals("JPEG") || FilenameExtension.equals("jpeg") || FilenameExtension.equals("JPG") || FilenameExtension.equals("jpg") || FilenameExtension.equals("PNG")
				|| FilenameExtension.equals("png")) {
			return "image/jpeg";
		}
		if (FilenameExtension.equals("HTML") || FilenameExtension.equals("html")) {
			return "text/html";
		}
		if (FilenameExtension.equals("TXT") || FilenameExtension.equals("txt")) {
			return "text/plain";
		}
		if (FilenameExtension.equals("VSD") || FilenameExtension.equals("vsd")) {
			return "application/vnd.visio";
		}
		if (FilenameExtension.equals("PPTX") || FilenameExtension.equals("pptx") || FilenameExtension.equals("PPT") || FilenameExtension.equals("ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		if (FilenameExtension.equals("DOCX") || FilenameExtension.equals("docx") || FilenameExtension.equals("DOC") || FilenameExtension.equals("doc")) {
			return "application/msword";
		}
		if (FilenameExtension.equals("XML") || FilenameExtension.equals("xml")) {
			return "text/xml";
		}
		if (FilenameExtension.equals("mp3") || FilenameExtension.equals("MP3")) {
			return "audio/mp3";
		}
		if (FilenameExtension.equals("wav") || FilenameExtension.equals("WAV")) {
			return "audio/wav";
		}
		if (FilenameExtension.equals("wma") || FilenameExtension.equals("WMA")) {
			return "audio/x-ms-wma";
		}
		if (FilenameExtension.equals("mp4") || FilenameExtension.equals("MP4")) {
			return "video/mpeg4";
		}
		return "application/octet-stream";
	}
}
