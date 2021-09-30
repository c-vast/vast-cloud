package com.vast.common.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * ID生成工具
 */
public class IdUtils {

    private static final int WORKER_ID = 1;
    private static final int DATA_CENTER_ID = 1;
    private static final Snowflake SNOWFLAKE = IdUtil.createSnowflake(WORKER_ID, DATA_CENTER_ID);

    public static long getSnowflakeId() {
        return SNOWFLAKE.nextId();
    }

    public static String getUUID() {
        return IdUtil.simpleUUID();
    }
}
