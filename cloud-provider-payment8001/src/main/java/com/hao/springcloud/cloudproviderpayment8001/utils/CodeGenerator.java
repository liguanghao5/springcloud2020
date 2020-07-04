package com.hao.springcloud.cloudproviderpayment8001.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        System.out.println("aa");
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = "D://springcloud2020/cloud-provider-payment8001";
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("liguanghao");//作者
        gc.setOpen(false);//是否打开输出目录
        gc.setFileOverride(true);//每次生成覆盖之间的
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setServiceName("%sService");//service前面没有“I"
        gc.setBaseResultMap(true);//生成基本的sql语句在xml中
        gc.setBaseColumnList(true);//生成sql片段在xml中
        mpg.setGlobalConfig(gc);

        //包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent("com.hao.springcloud.cloudproviderpayment8001");
        pc.setEntity("bean");

        mpg.setPackageInfo(pc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://localhost:3306/springcloud2020?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        /*数据库表配置*/
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);//全局大写命名

        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);//生成 @RestController 控制器


        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //strategy.setInclude("area");//或者可以写死需要生成代码的表，每次修改
        strategy.setControllerMappingHyphenStyle(true);//驼峰转连字符
        //strategy.setTablePrefix(pc.getModuleName() + "_");//表前缀
        mpg.setStrategy(strategy);



        mpg.execute();
    }


}
