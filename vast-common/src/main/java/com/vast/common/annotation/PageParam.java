package com.vast.common.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageParam {

    String currentName() default "current";

    String sizeName() default "size";

    String columnName() default "column";

    String isAscName() default "is_asc";
}
