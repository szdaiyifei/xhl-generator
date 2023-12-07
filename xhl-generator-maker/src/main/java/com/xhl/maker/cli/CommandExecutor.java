package com.xhl.maker.cli;

import com.xhl.maker.cli.command.ConfigCommand;
import com.xhl.maker.cli.command.GenerateCommand;
import com.xhl.maker.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "xhl", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        //不输入子命令时，给出友好的提示
        System.out.println("请输入具体命令，或者输入--help 查看命令提示");
    }

    /**
     * 执行命令
     */
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
