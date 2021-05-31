/*
 * Copyright (c) 2015-2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */

package com.jiangls.creationalpattern.factorymethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 使用静态工厂方法创建一个LocalDate
 */
public class LocalDateFactory {
    public static LocalDate fromInt(int yyyyMMdd) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(""+yyyyMMdd, dtf);
    }
}
