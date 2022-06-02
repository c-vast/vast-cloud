package com.vast.common.annotation.valid;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatValidId {
    String value() default "";
}
