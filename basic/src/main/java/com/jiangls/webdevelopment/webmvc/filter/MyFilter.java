package com.jiangls.webdevelopment.webmvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 如果一个Filter在当前请求中生效，但什么都没有做：那么，用户将看到一个空白页，因为请求没有继续处理，默认响应是200+空白输出。
 * @author jls
 *
 */
@WebFilter(filterName = "MyFilter", urlPatterns = "/testmyfilter/*")
public class MyFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO
    }
}
