package com.vast.common.annotation.valid;

import com.vast.common.enums.RepeatValidEnum;
import com.vast.common.validator.FieldRepeatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Constraint(validatedBy = FieldRepeatValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldRepeatValid {

    String message() default "数据重复";

    RepeatValidEnum type() default RepeatValidEnum.NONE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
