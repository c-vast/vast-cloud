package com.vast.common.validator;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.vast.common.annotation.valid.FieldRepeatValid;
import com.vast.common.annotation.valid.RepeatValidField;
import com.vast.common.annotation.valid.RepeatValidId;
import com.vast.common.enums.RepeatValidEnum;
import com.vast.common.exception.FieldRepeatException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class FieldRepeatValidator implements ConstraintValidator<FieldRepeatValid, Object> {

    private String message;

    private RepeatValidEnum type;

    @Override
    public void initialize(FieldRepeatValid constraintAnnotation) {
        message=constraintAnnotation.message();
        type=constraintAnnotation.type();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return checkRepeat(value);
    }


    private boolean checkRepeat(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String idColumnName = null;
        Object idColumnValue=null;
        Map<String,ValidFieldInfo> validFieldMap=new LinkedHashMap<>();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(RepeatValidId.class)) {
                RepeatValidId validId = f.getAnnotation(RepeatValidId.class);
                idColumnName= validId.value();
                if (StringUtils.isEmpty(idColumnName)){
                    idColumnName=f.getName();
                }
                try {
                    idColumnValue=f.get(o);
                } catch (IllegalAccessException e) {
                    throw new FieldRepeatException(e.getMessage());
                }
            }

            if (f.isAnnotationPresent(RepeatValidField.class)){
                Object value = null;
                try {
                    value = f.get(o);
                } catch (IllegalAccessException e) {
                    throw new FieldRepeatException(e.getMessage());
                }
                if (value==null){
                    break;
                }
                RepeatValidField validField = f.getAnnotation(RepeatValidField.class);
                String name = validField.value();
                if (StringUtils.isEmpty(name)){
                    name=f.getName();
                }
                String msg = validField.message();

                ValidFieldInfo validFieldInfo=new ValidFieldInfo();
                validFieldInfo.setMessage(msg);
                validFieldInfo.setName(name);
                validFieldInfo.setValue(value);

                validFieldMap.put(name,validFieldInfo);
            }
        }

        if (!CollectionUtil.isEmpty(validFieldMap)){
            checkRepeat(o,idColumnName,idColumnValue,validFieldMap);
        }
        return true;
    }

    private void checkRepeat(Object o,String idColumnName,Object idColumnValue,Map<String,ValidFieldInfo> validFieldMap) {
        Model model = (Model) o;
        QueryWrapper queryWrapper=null;
        Model result =null;
        switch (type){
            case AND:
                queryWrapper = new QueryWrapper<>();
                for (Map.Entry<String, ValidFieldInfo> entry :validFieldMap.entrySet()){
                    ValidFieldInfo value = entry.getValue();
                    queryWrapper.eq(entry.getKey(), value.getValue());
                }
                if (idColumnValue != null) {
                    queryWrapper.ne(idColumnName, idColumnValue);
                }
                result = model.selectOne(queryWrapper);
                if (result != null) {
                    throw new FieldRepeatException(message);
                }
                break;
            case OR:
                queryWrapper = new QueryWrapper<>();
                for (Map.Entry<String, ValidFieldInfo> entry :validFieldMap.entrySet()){
                    ValidFieldInfo value = entry.getValue();
                    queryWrapper.eq(entry.getKey(), value.getValue());
                    queryWrapper.or();
                }
                if (idColumnValue != null) {
                    queryWrapper.ne(idColumnName, idColumnValue);
                }
                result = model.selectOne(queryWrapper);
                if (result != null) {
                    throw new FieldRepeatException(message);
                }
                break;
            default:
                for (Map.Entry<String, ValidFieldInfo> entry :validFieldMap.entrySet()){
                    queryWrapper = new QueryWrapper<>();
                    ValidFieldInfo value = entry.getValue();
                    queryWrapper.eq(entry.getKey(), value.getValue());
                    if (idColumnValue != null) {
                        queryWrapper.ne(idColumnName, idColumnValue);
                    }
                    result = model.selectOne(queryWrapper);
                    if (result != null) {
                        throw new FieldRepeatException(value.getMessage());
                    }
                }
                break;
        }
    }

    @Data
    private static class ValidFieldInfo{
        private String name;
        private Object value;
        private String message;
    }
}
