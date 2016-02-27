package com.qawaa.web.security;

import java.security.MessageDigest;

/**
 * @author Ryan  2010-8-29  下午04:18:54
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 *
 */
public class MD5 {
	private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7","8", "9", "a", "b", "c", "d", "e", "f"}; 

	private static String byteArrayToHexString(byte[] b) 
	{ 
	   StringBuffer resultSb = new StringBuffer(); 
	   for (int i=0; i<b.length; i++) 
	   { 
	    resultSb.append(byteToHexString(b[i])); 
	   } 
	   return resultSb.toString().toLowerCase(); 
	} 

	private static String byteToHexString(byte b) 
	{ 
	   int n=b; 
	   if (n<0) 
	   { 
	    n=256+n; 
	   } 
	   int d1=n/16; 
	   int d2=n%16; 
	   return hexDigits[d1]+hexDigits[d2]; 
	} 


	public static String MD5Encode(String origin) 
	{ 
	   String resultString=null; 
	   try 
	   { 
	    resultString=new String(origin); 
	    MessageDigest md=MessageDigest.getInstance("MD5"); 
	    resultString=byteArrayToHexString( md.digest(resultString.getBytes()) ); 
	   } 
	   catch (Exception ex) 
	   { 
	   } 
	   return resultString; 
	} 
	
}
