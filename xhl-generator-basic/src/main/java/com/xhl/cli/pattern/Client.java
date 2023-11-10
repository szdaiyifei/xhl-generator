package com.xhl.cli.pattern;

/**
 * 客户端，使用遥控器的人
 */
public class Client {
    public static void main(String[] args) {
        //创建接收者对象
        Device tv = new Device("TV");
        Device stereo = new Device("Stereo");

        //创建具体命令对象，可以保定不同的设备

        TurnOnCommand turnOn = new TurnOnCommand(tv);
        TurnOffCommand turnOff = new TurnOffCommand(stereo);

        //创建调用者
        RemoteControl remoteControl = new RemoteControl();

        //执行命令
        remoteControl.setCommand(turnOn);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOff);
        remoteControl.pressButton();


    }
}
