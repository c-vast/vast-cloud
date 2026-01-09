package com.vast.common.validator;

import cn.hutool.core.util.ReflectUtil;
import com.vast.common.annotation.valid.AtLeastOneNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Copyright (C), 2020-2022, c-vast
 *
 * @version 1.0.0
 * @className: AtLeastOneNotNullValidator
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2022/6/5 15:59
 * @description:
 */
public class AtLeastOneNotNullValidator implements ConstraintValidator<AtLeastOneNotNull, Object> {

    private String[] fieldNames;

    @Override
    public void initialize(AtLeastOneNotNull constraintAnnotation) {
        this.fieldNames = constraintAnnotation.fieldNames();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {
        if (object == null) {
            return true;
        }
        try {
            for (String fieldName : fieldNames) {
                Object property = ReflectUtil.getField(object.getClass(), fieldName);
                if (property != null) return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
