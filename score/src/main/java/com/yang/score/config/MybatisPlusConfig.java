package com.yang.score.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Configuration
@EnableTransactionManagement
@MapperScan("com.yang.**.mapper")
public class MybatisPlusConfig implements MetaObjectHandler {

    private static final String SERVER_ZONE = "Asia/Shanghai";;

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createdTime", ZonedDateTime.class, ZonedDateTime.now(ZoneId.of(SERVER_ZONE)));
        this.strictUpdateFill(metaObject, "updatedTime", ZonedDateTime.class, ZonedDateTime.now(ZoneId.of(SERVER_ZONE)));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatedTime", ZonedDateTime.class, ZonedDateTime.now(ZoneId.of(SERVER_ZONE)));
    }
}
