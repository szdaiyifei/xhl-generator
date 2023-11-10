package com.xhl.cli.pattern;

/**
 * 接收者，执行操作的对象
 */
public class Device {

    private String name;

    public Device(String name) {
        this.name = name;
    }


    public void turnOn() {
        System.out.println(name + "设备开启");
    }

    public void turnOff() {
        System.out.println(name + "设备关闭");
    }

}
