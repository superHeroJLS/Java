package com.jiangls.digester;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * @author Jiangls
 * @date 2022/3/6
 */
public class Main {
    public static void main(String[] args) throws IOException, SAXException {
        Digester d = new Digester();
        d.setValidating(false);

        d.addObjectCreate("department", Department.class);
        d.addSetProperties("department");
        d.addObjectCreate("department/user", User.class);
        d.addSetProperties("department/user");
        d.addSetNext("department/user", "addUser");
        d.addCallMethod("department/extension", "putExtension", 2);
        d.addCallParam("department/extension/property-name", 0);
        d.addCallParam("department/extension/property-value", 1);

        Main m = new Main();
        Department depart = d.parse(m.getClass().getResourceAsStream("/digester/test.xml"));
        System.out.println(depart);
    }
}
