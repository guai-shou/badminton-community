package com.cloud;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import org.apache.velocity.Template;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/1/22 15:39
 */
public class MysqlGenerator {

    private static final String DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://localhost/blog", "root", "root").build();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .fileOverride()
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .outputDir(DIR + "/src/main/java")
                .build();

        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.cloud.project")
                .serviceImpl("service.impl")
                .build();

        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .disable().build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .enableCapitalMode()
                .enableSkipView()
                .entityBuilder()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .logicDeleteColumnName("deleted")
                .logicDeletePropertyName("deleteFlag")
                .build();

        // 执行自动化
        new AutoGenerator(dataSourceConfig)
                .global(globalConfig)
                .template(templateConfig)
                .packageInfo(packageConfig)
                .strategy(strategyConfig)
                .execute();




    }
}
