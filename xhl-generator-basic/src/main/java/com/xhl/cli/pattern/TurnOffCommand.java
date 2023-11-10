package com.xhl.cli.pattern;

/**
 * 命令的具体实现
 */
public class TurnOffCommand implements Command {
    private Device device;


    public TurnOffCommand(Device device) {
        this.device = device;
    }


    public void execute() {
        device.turnOff();
    }
}
