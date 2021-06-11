package com.jiangls.ioc.annotationconfiguration.springaop.service;

import com.jiangls.ioc.annotationconfiguration.springioc.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private MailService mailService;
    
    public void test() {
        System.out.println("welcome test!");
    }
    
    public void send() {
        mailService.sendLoginMail(new User(1,  null, null, "lisi"));
    }
    
    
}
