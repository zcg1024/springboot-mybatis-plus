package com.zcg.springboot_mybatis_plus;

import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import org.jetbrains.annotations.NotNull;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;

/**
 * PROJECT_NAME: springboot-mybatis-plus
 * ClassName: ThymeleafTemplateEngine
 * Package: com.zcg.springboot_mybatis_plus
 * Description:
 *  实现 Thymeleaf 引擎适配器
 * @Author CaigaoZhang
 * @Flag Effort, Struggle !
 * @Create 2025-04-22 19:03:14 星期二
 * @Version 1.0
 */
public class ThymeleafTemplateEngine extends AbstractTemplateEngine {

    private TemplateEngine thymeleafEngine;

    /**
     * init() 方法：
     * 必须调用 super.init(configBuilder)：父类会初始化必要的配置
     * 配置模板解析器：设置模板路径、编码等基础参数
     * @param configBuilder
     * @return
     */
    @Override
    public @NotNull AbstractTemplateEngine init(@NotNull ConfigBuilder configBuilder) {
        // 配置Thymeleaf解析器(初始化Thymeleaf引擎)
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("/templates/"); // 模板存放路径
        resolver.setSuffix(".html");      // 模板后缀
        resolver.setTemplateMode(TemplateMode.TEXT); // 文本模式
        resolver.setCharacterEncoding(ConstVal.UTF8);

        this.thymeleafEngine = new TemplateEngine();
        this.thymeleafEngine.setTemplateResolver(resolver);

        return this;
    }

    /**
     * writer() 方法：
     * 使用 Thymeleaf 的 Context 承载变量
     * 通过 FileWriter 输出到目标文件
     * 自动处理资源释放（try-with-resources）
     * @param objectMap    渲染对象 MAP 信息
     * @param templatePath 模板文件
     * @param outputFile   文件生成的目录
     * @throws Exception
     */
    @Override
    public void writer(@NotNull Map<String, Object> objectMap,
                       @NotNull String templatePath,
                       @NotNull File outputFile) throws Exception {
        Context context = new Context();
        context.setVariables(objectMap);

        try (Writer writer = new FileWriter(outputFile)) {
            thymeleafEngine.process(templatePath, context, writer);
        }
        //添加日志(查看模板解析过程)
        System.out.println("Generating: " + outputFile.getAbsolutePath());
        System.out.println("Using template: " + templatePath);
    }

    /**
     * templateFilePath() 方法：
     * 统一添加模板后缀（.html）
     * 保持与 Thymeleaf 配置的一致性
     * @param filePath 文件路径
     * @return
     */
    @Override
    public @NotNull String templateFilePath(@NotNull String filePath) {
        return filePath + ".html"; // 自动补全模板后缀
    }

    // 可选实现：字符串模板渲染
    @Override
    public String writer(@NotNull Map<String, Object> objectMap,
                         @NotNull String templateName,
                         @NotNull String templateContent) throws Exception {
        Context context = new Context();
        context.setVariables(objectMap);
        return thymeleafEngine.process(templateName, context);
    }
}
