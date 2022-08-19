package com.vast.common.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.vast.common.constant.DatePatternConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    private static String getRandomId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DatePatternConstants.DATE_TIME_FORMAT_YYYYMMDDHHMISS);
        String randomId = dateFormat.format(new Date());
        return RandomUtils.getRandomStr(3) + randomId + RandomUtils.getRandomStr(3);
    }
}
