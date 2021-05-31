/*
 * Copyright (c) 2015-2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */

package com.jiangls.creationalpattern.abstractfactory;

/**
 * @Author jiangls
 * @Date 2020/9/1 10:23
 */
public class FastFactory implements AbstractFactory {
    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument();
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument();
    }
}
