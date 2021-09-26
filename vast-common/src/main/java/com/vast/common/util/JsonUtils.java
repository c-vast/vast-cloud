package com.vast.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * 基于fastjson封装的json转换工具类
 */
public class JsonUtils {
    public static String objectToJson(Object object) {
        return JSON.toJSONString(object);
    }
    public static <T> T jsonToObject(String json,Class<T> clazz) {
        return JSON.parseObject(json,clazz);
    }
    public static <T> List<T> jsonToList(String json,Class<T> clazz) {
        return JSON.parseArray(json,clazz);
    }
    public static <K,V> Map<K,V> jsonToMap(String json,Class<K> keyClass,Class<V> valueClass){
        return JSON.parseObject(json,new TypeReference<Map<K,V>>(){});
    }
}
