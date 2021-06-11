package com.jiangls.webdevelopment.webmvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Log Filter: /* 代表所有路径
 * @author jls
 */
@WebFilter(filterName = "LogFilter", urlPatterns = "/*")
public class LogFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("LogFilter: process " + ((HttpServletRequest) request).getRequestURI() + ",method: " + ((HttpServletRequest) request).getMethod());
        
        chain.doFilter(request, response);
    }
}
