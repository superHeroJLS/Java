package com.jiangls.webdevelopment.webmvc.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ServletContext Listener：监听webApp的创建和销毁
 * @author jls
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
    // 在此初始化WebApp,例如打开数据库连接池等:
    public void contextInitialized(ServletContextEvent sce) {
    	String contextPath = sce.getServletContext().getContextPath();// 如果是 root webapp，contextPath将为空字符串
        System.out.println("WebApp: " + contextPath + " initialized.");
    }

    // 在此清理WebApp,例如关闭数据库连接池等:
    public void contextDestroyed(ServletContextEvent sce) {
    	String contextPath = sce.getServletContext().getContextPath();
        System.out.println("WebApp: " + contextPath + " destroyed.");
    }
}
