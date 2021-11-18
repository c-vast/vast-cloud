package com.vast.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    private final String CREATE_TIME = "createTime";
    private final String UPDATE_TIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter(CREATE_TIME)) {
            Object createTime = getFieldValByName(CREATE_TIME, metaObject);
            if (createTime == null) {
                strictInsertFill(metaObject, CREATE_TIME, Date.class, new Date());
            }
        }
        if (metaObject.hasSetter(UPDATE_TIME)) {
            Object updateTime = getFieldValByName(UPDATE_TIME, metaObject);
            if (updateTime == null) {
                strictInsertFill(metaObject, UPDATE_TIME, Date.class, new Date());
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter(UPDATE_TIME)) {
            Object updateTime = getFieldValByName(UPDATE_TIME, metaObject);
            if (updateTime == null) {
                strictUpdateFill(metaObject, UPDATE_TIME, Date.class, new Date());
            }
        }
    }
}
