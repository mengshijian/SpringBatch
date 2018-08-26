package com.cml.learning.framework.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface JobInfo {
    String group() default "";

    String name() default "";

    String cronExp() default "";
}
