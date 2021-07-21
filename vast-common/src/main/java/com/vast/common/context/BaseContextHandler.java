package com.vast.common.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: BaseContextHandler
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/18 15:50
 * @description:
 */
public class BaseContextHandler {
    protected static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();
    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
