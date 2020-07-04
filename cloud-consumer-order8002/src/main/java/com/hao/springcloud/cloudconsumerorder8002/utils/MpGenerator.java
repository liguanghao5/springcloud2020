package com.hao.springcloud.cloudconsumerorder8002.utils;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
@Component
public class MpGenerator {

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("Mht");
        gc.setOutputDir("D://workspace/spring-boot-mybatis/src/main/java");
        gc.setFileOverride(false);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList

        mpg.setGlobalConfig(gc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "user_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.no_change);// 表名生成策略
        strategy.setInclude(new String[] { "user" }); // 需要生成的表
        mpg.setStrategy(strategy);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();

        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://139.129.101.74:3306/springcloud2020?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        mpg.setDataSource(dsc);



        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.mht.springbootmybatis");
        mpg.setPackageInfo(pc);



        // 执行生成
        mpg.execute();

    }

}
