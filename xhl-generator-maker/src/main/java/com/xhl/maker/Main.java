package com.xhl.maker;


import com.xhl.maker.cli.CommandExecutor;
import com.xhl.maker.generator.main.MainGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * 调用入口
 */
public class Main {


    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }
}
