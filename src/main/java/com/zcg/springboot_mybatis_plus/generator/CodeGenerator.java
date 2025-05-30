package com.zcg.springboot_mybatis_plus.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.H2Query;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.zcg.springboot_mybatis_plus.ThymeleafTemplateEngine;

import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PROJECT_NAME: springboot-mybatis-plus
 * ClassName: CodeGenerator
 * Package: com.zcg.springboot_mybatis_plus.utils
 * Description:
 *  代码生成器类，指定模板
 * @Author CaigaoZhang
 * @Flag Effort, Struggle !
 * @Create 2025-04-22 19:12:08 星期二
 * @Version 1.0
 */
public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:h2:file:E:/Develop/IDEA_Projects/springboot-mybatis-plus/data/auto/h2db/testdb", "root", "root")
                .globalConfig(builder -> {
                    builder.author("zhangcaigao") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(System.getProperty("user.dir") + "/src/main/java"); // Java源代码输出目录
                    System.out.println("user.dir path: " + System.getProperty("user.dir")); //user.dir 是 Java 系统属性，表示 用户当前的工作目录（User Working Directory）。它的具体路径取决于你运行程序时的上下文环境
                    System.out.println("Java源代码输出目录outputDir: " + System.getProperty("user.dir") + "/src/main/java");
                })
                //MySQL 下 tinyint 字段转换问题：
                //当字段长度为 1 时，无法转换成 Boolean 字段，建议在指定数据库连接时添加 &tinyInt1isBit=true。
                //当字段长度大于 1 时，默认转换成 Byte，如果想继续转换成 Integer, 可使用如下代码：
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder -> {
                    builder.parent("com.zcg") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper")); // 设置mapperXml生成路径
                    System.out.println("mapperXml生成路径: " + System.getProperty("user.dir") + "/src/main/resources/mapper");
                })
                .strategyConfig(builder -> {

//                    builder.addInclude("USER")
                    builder.addInclude("\"user\"","\"t_simple\"") // 设置需要生成的表名(生成多张表用,隔开,这里是同时生成user、t_simple 两张表)
                            .entityBuilder()
                            .enableLombok(); // 使用Lombok
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new ThymeleafTemplateEngine())  // 使用Thymeleaf引擎
                .execute();
    }
}