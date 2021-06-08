package com.jiangls.serializable.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainFilters {

    /** 业务数据域数据过滤器 Code 列表 */
    String[] value() default {};
}
