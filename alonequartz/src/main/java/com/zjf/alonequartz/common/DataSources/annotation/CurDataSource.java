package com.zjf.alonequartz.common.DataSources.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * AOP拦截此注解更换数据源
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurDataSource {

    String name() default "";
}
