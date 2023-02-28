package com.cloud.badminton.framework.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 13:38
 */
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ...");
        this.strictInsertFill(metaObject, "createTime", LocalDate.class, LocalDate.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ...");
        this.strictUpdateFill(metaObject, "updateTime", LocalDate.class, LocalDate.now());
    }
}
