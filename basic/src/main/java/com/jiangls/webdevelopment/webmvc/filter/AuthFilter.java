package com.jiangls.webdevelopment.webmvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Auth Filter，登录认证过滤器: /user/* 只过滤/user/开头的路径
 * <p>有多个Filter的时候，Filter的顺序如何指定？多个Filter按不同顺序处理会造成处理结果不同吗？</p>
 * <p>Filter的顺序确实对处理的结果有影响。但遗憾的是，Servlet规范并没有对@WebFilter注解标注的Filter规定顺序。
 * 如果一定要给每个Filter指定顺序，就必须在<b>web.xml</b>文件中对这些Filter再配置一遍。</p>
 * @author jls
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = "/user/*")
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("AuthFilter: check authentication");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        if (req.getSession().getAttribute("user") == null) {
            // 未登录，自动跳转到登录页:
        	/*
        	 * 没有调用chain.doFilter()，因此，当用户没有登录时，请求到达AuthFilter后，
        	 * 不再继续处理，即后续的Filter和任何Servlet都没有机会处理该请求了。
        	 * 可见，Filter可以有针对性地拦截或者放行HTTP请求。
        	 */
            System.out.println("AuthFilter: not signin!");
            resp.sendRedirect("/signin");
        } else {
            // 已登录，继续处理:
            chain.doFilter(request, response);
        }
    }
}
