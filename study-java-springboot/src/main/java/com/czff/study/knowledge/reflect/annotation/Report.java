package com.czff.study.knowledge.reflect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cuidi
 * @date 2022/6/9 15:07
 * @description
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {
    int type() default 0;

    String level() default "info";

    String value() default "疾风劲草";
}
