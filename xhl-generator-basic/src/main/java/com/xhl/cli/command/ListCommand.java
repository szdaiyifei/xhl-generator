package com.xhl.cli.command;


import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.List;

@Command(name = "list", description = "查看生成文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {
    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");
        //整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        //输入路径
        String inputPath = new File(parentFile, "xhl-generator-demo-projects/acm-template").getAbsolutePath();
        List<File> list = FileUtil.loopFiles(inputPath);
        for (File file : list) {
            System.out.println(file);
        }
    }
}
