package com.wds.datasources.annotation;

import java.lang.annotation.*;

/**
 * @author : TenYun
 * @date : 2019-06-17 13:18
 * @description : 切换数据注解 可以用于类或者方法级别 方法级别优先级 > 类级别
 **/
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value() default "master"; //该值即key值

}
