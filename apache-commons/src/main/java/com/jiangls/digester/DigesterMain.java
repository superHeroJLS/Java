package com.jiangls.digester;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * @author Jiangls
 * @date 2022/3/6
 */
public class DigesterMain {
    public static void main(String[] args) throws IOException, SAXException {
        /*
            创建Digester对象，且添加匹配模式以及对应的处理规则
         */
        Digester d = new Digester();
        d.setValidating(false);

        // 匹配department节点时，创建Department对象
        d.addObjectCreate("department", Department.class);
        // 匹配department节点时，设置对象属性
        d.addSetProperties("department");
        // 匹配department/user节点时，创建User对象
        d.addObjectCreate("department/user", User.class);
        // 匹配department/user节点时，设置对象属性
        d.addSetProperties("department/user");
        // 匹配department/user节点时，调用Department对象的addUser方法
        d.addSetNext("department/user", "addUser");
        // 匹配department/extension节点时，调用Department对象的putExtension方法
        d.addCallMethod("department/extension", "putExtension", 2);
        // 调用方法的第一个参数为节点department/extension/property-name的内容
        d.addCallParam("department/extension/property-name", 0);
        // 调用方法的第一个参数为节点department/extension/property-value的内容
        d.addCallParam("department/extension/property-value", 1);

        DigesterMain m = new DigesterMain();
        Department depart = d.parse(m.getClass().getResourceAsStream("/digester/test.xml"));
        System.out.println(depart);
    }
}
