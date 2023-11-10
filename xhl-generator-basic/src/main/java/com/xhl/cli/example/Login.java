package com.xhl.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

@Command
public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", interactive = true, echo = true, required = true)
    String password;

    @Option(names = {"-cp", "--check-password"}, arity = "0..1", description = "Check password", interactive = true, echo = true)
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("user =" + user);
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    // 辅助方法：将选项添加到 args 数组的末尾
    private static String[] appendOption(String[] args, String option) {
        String[] newArgs = new String[args.length + 1];
        System.arraycopy(args, 0, newArgs, 0, args.length);
        newArgs[args.length] = option;
        return newArgs;
    }

    public static void main(String[] args) {
        Login login = new Login();

        // 获取 Login 类中的所有字段
        Field[] fields = Login.class.getDeclaredFields();
        List<String> requiredOptions = new ArrayList<>();

        for (Field field : fields) {
            // 检查字段是否具有 @Option 注解并且 required = true
            if (field.isAnnotationPresent(Option.class)) {
                Option option = field.getAnnotation(Option.class);
                if (option.required()) {
                    requiredOptions.add(option.names()[0]);

                }
            }
        }


        // 检查 args 数组中是否存在 requiredOptions 列表中的值
        for (String requiredOption : requiredOptions) {
            boolean optionExists = false;
            for (String arg : args) {
                if (arg.equals(requiredOption)) {
                    optionExists = true;
                    break;
                }
            }
            if (!optionExists) {
                args = appendOption(args, requiredOption);
            }
        }

        new CommandLine(new Login()).execute(args);
    }




}
