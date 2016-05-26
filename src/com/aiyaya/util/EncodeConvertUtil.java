package com.aiyaya.util;

import java.io.UnsupportedEncodingException;

/**
 * 编码转换工具类
 * @author YJM
 *
 */
public class EncodeConvertUtil {
	
	/**
	 * iso-8859-1 转换为 utf-8
	 * @param str
	 * @return
	 */
	public static String ISOToUTF(String str){
		String result = null;
		
		try{
			result = new String(str.getBytes("iso-8859-1"),"utf-8");
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
