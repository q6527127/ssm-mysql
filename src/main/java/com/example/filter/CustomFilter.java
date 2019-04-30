package com.example.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mazhenhua on 2016/12/27.
 *
 * 过滤器
 */
public class CustomFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		 HttpServletRequest request= (HttpServletRequest) arg0;
	        HttpServletResponse response = (HttpServletResponse) arg1;
	        //全路径  http://localhost:8080/test/index.do
	        String url="http://" + request.getServerName() //服务器地址    
	        + ":"     
	        + request.getServerPort()           //端口号    
	        + request.getRequestURI(); // test/index.do
	        //全面完整URL
	        // String url = "http://" + request.getServerName() //服务器地址  
	        // + ":"   
	        // + request.getServerPort()           //端口号  
	        // + request.getContextPath()     //项目名称 
	        //	      + request.getServletPath()      //请求页面或其他地址  
	        //  + "?" + (request.getQueryString()); //参数
	        System.out.printf("过滤器拦截地址:"+url);
	        arg2.doFilter(request,response);
	        if (url.indexOf("index")!=-1||url.indexOf("js")!=-1||url.indexOf("css")!=-1||url.indexOf("ftl")!=-1) {
		        //arg2.doFilter(request,response);
			}else {
				//重定向 ！！ 需要加 web项目
		        //String cdxPath = "/test/index.do";
				//转发   ！！ 不需要加 web项目
		        //String zfPath = "/index.do";
		        //重定向
		        //response.sendRedirect(cdxPath);
		        //转发
	            //RequestDispatcher dispatcher = request.getRequestDispatcher(zfPath);
	            //dispatcher.forward(request, response);
			}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}