package com.xhl.maker.generator.main;


/**
 * 子类，可以重写方法覆盖
 */
public class MainGenerator extends GenerateTemplate{
    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("不再生成Dist了");
    }

}
