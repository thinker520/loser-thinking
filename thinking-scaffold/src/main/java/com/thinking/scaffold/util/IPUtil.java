package com.thinking.scaffold.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {

	public static String getIp(HttpServletRequest request) {
		String ip = "";
		//1.获取客户端请求的完整URL  
        String url = request.getRequestURL().toString();  
        System.out.println(url);  
          
        //2.获取客户端请求的资源部分的名称  
        String uri = request.getRequestURI().toString();  
        System.out.println(uri);  
          
        //3.获取请求行的参数部分  
        String qStr = request.getQueryString().toString();  
        System.out.println(qStr);  
          
        //4.获取请求客户端的ip地址  
        ip = request.getRemoteAddr();  
        System.out.println(ip);  
          
        //5.获取客户机的请求方式  
        String method = request.getMethod();  
        System.out.println(method);  
          
        //6.获取当前web应用的名称,不是工程名
        String webName = request.getContextPath();  
        System.out.println(webName);    //7.给一个请求头名称，获取其值  
        String host = request.getHeader("Host");  
        System.out.println(host);  
 
        //8.获取所有请求头名字组成的枚举  
        Enumeration<String> enumeration = request.getHeaderNames();  
        while (enumeration.hasMoreElements()) {  
            String name = (String) enumeration.nextElement();  
            String values = request.getHeader(name);  
            System.out.println(name+":"+values);  
        }
		return ip;
	}
}
