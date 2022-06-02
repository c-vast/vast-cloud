package com.vast.common.annotation.valid;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatValidField {
    String value() default "";
    String message() default "字段重复";
}
