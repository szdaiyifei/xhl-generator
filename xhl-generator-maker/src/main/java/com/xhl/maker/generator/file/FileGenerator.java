package com.xhl.maker.generator.file;

import com.xhl.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 动静结合：先静态生成所有文件，再动态覆盖
 */
public class FileGenerator {


    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        //整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();

        String inputPath = new File(parentFile, "xhl-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        //生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);
        //生成动态文件
        String inputPathDynamic = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPathDynamic = projectPath + File.separator + "acm-template/src/com/xhl/MainTemplate.java";
        DynamicFileGenerator.doGenerate(inputPathDynamic, outputPathDynamic, model);


    }

    public static void main(String[] args) throws TemplateException, IOException {
        DataModel mainTemplateConfig = new DataModel();
        mainTemplateConfig.setAuthor("xhl");
        mainTemplateConfig.setOutputText("求和结果：");
        mainTemplateConfig.setLoop(false);
        doGenerate(mainTemplateConfig);

    }
}
