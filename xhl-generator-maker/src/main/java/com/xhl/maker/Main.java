package com.xhl.maker;


import com.xhl.maker.cli.CommandExecutor;

/**
 * 调用入口
 */
public class Main {


    public static void main(String[] args) {
//        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        //创建调用者对象
        CommandExecutor commandExecutor = new CommandExecutor();
        //执行命令
        commandExecutor.doExecute(args);
    }
}
