package com.vast.common.util;

import org.springframework.beans.BeanUtils;

public class Utils {
    public static <T> T BeanConverter(Class<T> clazz, Object o) {
        try {
            T t = clazz.newInstance();
            BeanUtils.copyProperties(o, t);
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> void BeanConverter(T t,Object o){
        BeanUtils.copyProperties(o,t);
    }
}
