package com.cloud.note.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;



public class NoteUtil {
	//加密：md5+base64
	public static String md5(String msg) throws NoSuchAlgorithmException {
	    //信息处理msg
		MessageDigest md=MessageDigest.getInstance("MD5");
		
		byte[] in=msg.getBytes();
		byte[] out=md.digest(in);
		String message=Base64.encodeBase64String(out);
		
		return message;
	}
	
	
          public static String createId() {
        	 UUID uuid= UUID.randomUUID();
        	 return uuid.toString();
          }
          public static void main(String []args) throws NoSuchAlgorithmException {
        	  System.out.print(md5("xxh"));
          }
}
