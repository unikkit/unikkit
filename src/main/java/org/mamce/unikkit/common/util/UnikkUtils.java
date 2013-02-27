package org.mamce.unikkit.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UnikkUtils {

	public static String hashIt(String str) {
		String md5 = null;
        
        if(null == str) return null;
         
        try {
             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
         
        //Update input string in message digest
        digest.update(str.getBytes(), 0, str.length());
 
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
           return null;
        }
        return md5;
	}
	
	public static void main(String[] args) {
		System.out.println(hashIt("admin"));
	}
}
