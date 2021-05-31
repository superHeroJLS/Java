/*
 * Copyright (c) 2015-2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */

package com.jiangls.creationalpattern.abstractfactory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @Author jiangls
 * @Date 2020/9/1 10:24
 */
public class Client {
    public static void main(String[] args) throws IOException {

        // 1.可以使用FastFactory创建的FastHtmlDocument和FastWordDocument
        // 创建AbstractFactory，实际类型是FastFactory:
        AbstractFactory factory = new FastFactory();
        // 生成Html文档:
        HtmlDocument html = factory.createHtml("#Hello\nHello, world!");
        html.save(Paths.get(".", "fast.html"));
        // 生成Word文档:
        WordDocument word = factory.createWord("#Hello\nHello, world!");
        word.save(Paths.get(".", "fast.doc"));

        // 2.可以使用GoodFactory创建的GoodHtmlDocument和GoodWordDocument
        // 创建AbstractFactory，实际类型是GoodFactory:
        AbstractFactory factory1 = new GoodFactory();
        // 生成Html文档:
        HtmlDocument html1 = factory1.createHtml("#Hello\nHello, world!");
        html1.save(Paths.get(".", "fast.html"));
        // 生成Word文档:
        WordDocument word1 = factory1.createWord("#Hello\nHello, world!");
        word1.save(Paths.get(".", "fast.doc"));

        /*
        注意到客户端代码除了通过new创建了FastFactory或GoodFactory外，其余代码只引用了产品接口，
        并未引用任何实际产品（例如，FastHtmlDocument），如果把创建工厂的代码放到AbstractFactory中，就可以连实际工厂也屏蔽了
         */
        AbstractFactory factory2 = AbstractFactory.createFactory("good");

    }
}
