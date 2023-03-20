package com.jiangls.ioc.annotationconfiguration.springioc.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Jiangls
 * @date 2022/9/25
 */
public class SecurityInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        this.doSecurityCheck();
        return invocation.proceed();
    }

    protected void doSecurityCheck() {
        // do something
    }
}
