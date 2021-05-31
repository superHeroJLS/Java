/*
 * Copyright (c) 2015-2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */

package com.jiangls.creationalpattern.factorymethod;

import java.math.BigDecimal;

/**
 * 实际上大多数情况下我们并不需要抽象工厂NumberFactory，而是通过工厂的静态方法(Static Factory Method)直接返回产品Number<br/>
 * 静态工厂方法优点：工厂方法可以隐藏创建产品的具体实现，即使是具体实现发生了改变，也不会影响到调用者的调用。
 */
public class StaticNumberFacotry {
    public static Number parse(String s) {
        return new BigDecimal(s);
    }
}
