package org.thinking.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 * @author KINGYE
 */
public class StringUtil {

	/**
	 * 判断是否为NULL或者""
	 * @param str 内容
	 * @return true or false
	 */
	public static boolean isNullOrBlank(String str) {
		return null == str || "".equals(str);
	}
	
	public static Boolean isMobile(String mobile) {
        if (mobile == null || mobile.trim().length() != 11) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(1[0123456789])\\d{9}$");
        Matcher matcher = pattern.matcher(mobile);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		System.out.println(isMobile(""));
	}
}
