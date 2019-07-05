package com.utils.signalg;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 签名工具类
 * 
 * Created by feng.wei on 20171111.
 *
 */
public class MD5Utils {

	/**
	 * 32 位加密函数
	 * 
	 * @param plainText
	 *            加密字符串
	 * @return
	 */
	public static String md5s(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			System.out.println("result: " + buf.toString());// 32位的加密
			return buf.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 16位加密函数
	 * 
	 * @param s
	 *            加密字符串
	 * @return
	 */
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * 加密
	 * 
	 * @param passwordStr
	 *            加密字符串
	 * @param saltStr
	 *            盐值
	 * @param hashIterations
	 *            hash值
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5(String passwordStr, String saltStr, int hashIterations) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");

		md5.reset();
		// md5.update(saltStr.getBytes());
		// byte[] hashed = md5.digest((passwordStr).getBytes());
		byte[] hashed = md5.digest((passwordStr + saltStr).getBytes());
		int iterations = hashIterations - 1; // already hashed once above
		// iterate remaining number:
		for (int i = 0; i < iterations; i++) {
			md5.reset();
			hashed = md5.digest(hashed);
		}

		StringBuilder sb = new StringBuilder();

		for (byte b : hashed) {
			sb.append(String.format("%02X", b)); // 10进制转16进制，X 表示以十六进制形式输出，02
													// 表示不足两位前面补0输出
		}
		return sb.toString().toLowerCase();
	}
}
