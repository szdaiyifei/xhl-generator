package com.xhl.generator;

import com.xhl.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 动静结合：先静态生成所有文件，再动态覆盖
 */
public class MainGenerator {


    public static void doGenerate(Object model) throws TemplateException, IOException {
//        String projectPath = System.getProperty("user.dir");
//        //整个项目的根路径
//        File parentFile = new File(projectPath).getParentFile();

        String inputRootPath = "G:\\szdai\\星球项目\\定制化代码生成\\代码\\xhl-generator\\xhl-generator-demo-projects\\acm-template-pro";
        String outputRootPath = "G:\\szdai\\星球项目\\定制化代码生成\\代码\\xhl-generator\\acm-template-pro";

        String inputPath;
        String outputPath;
        inputPath = new File(inputRootPath, "src/com/xhl/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath, "src/com/xhl/acm/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, model);
//        String inputPath = new File(inputRootPath, "xhl-generator-demo-projects/acm-template").getAbsolutePath();
//        String outputPath = projectPath;
        //生成静态文件
        inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        inputPath = new File(inputRootPath, "README.md").getAbsolutePath();
        outputPath = new File(outputRootPath, "README.md").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
//        //生成动态文件
//        String inputPathDynamic = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
//        String outputPathDynamic = projectPath + File.separator + "acm-template/src/com/xhl/MainTemplate.java";
//        DynamicGenerator.doGenerate(inputPathDynamic, outputPathDynamic, model);


    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("xhl");
        mainTemplateConfig.setOutputText("求和结果：");
        mainTemplateConfig.setLoop(false);
        doGenerate(mainTemplateConfig);

    }
}
