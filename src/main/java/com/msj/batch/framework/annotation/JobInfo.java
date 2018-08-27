package com.msj.batch.framework.annotation;

import java.lang.annotation.*;
import java.util.UUID;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface JobInfo {
    String group();

    String name();

    String cronExp();
}
