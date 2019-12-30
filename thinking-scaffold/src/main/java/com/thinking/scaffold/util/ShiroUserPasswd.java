package com.thinking.scaffold.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class ShiroUserPasswd {

	public static void main(String[] args) {
		String hashAlgorithmName = "MD5";//加密方式
		Object crdentials = "1111aaaa";//密码原值
		Object salt = "" + System.currentTimeMillis();//盐值
		int hashIterations = 1024;//加密1024次
		Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
		System.out.println("result:" + result + " salt:" + salt);
		
		 //调用SimpleHash指定散列算法参数：1、算法名称；2、用户输入的密码；3、盐值（随机生成的）；4、迭代次数
        String newPassword = new SimpleHash(
        		hashAlgorithmName,
        		crdentials,
                ByteSource.Util.bytes(salt),
                hashIterations).toHex();
        System.out.println("newPassword:" + newPassword);
        
        System.out.println(ShiroUtil.salt("123456", "4"));
		
	}
}
