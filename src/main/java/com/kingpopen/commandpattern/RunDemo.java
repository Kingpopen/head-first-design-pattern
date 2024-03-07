package com.kingpopen.commandpattern;

import com.kingpopen.commandpattern.impl.LightOffCommand;
import com.kingpopen.commandpattern.impl.LightOnCommand;
import com.kingpopen.commandpattern.impl.StereoOffCommand;
import com.kingpopen.commandpattern.impl.StereoOnCommand;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 运行类
 * @date 2024/03/06 21:22:58
 */
@Slf4j
public class RunDemo {

  public static void main(String[] args) {
//    commandDemo();

    macroCommandDemo();
  }

  private static void commandDemo() {
    // 遥控器
    RemoteController remoteController = new RemoteController(7);
    // 灯
    Light bedroomLight = new Light("卧室灯");
    // 音响
    Stereo stereo = new Stereo();

    // 灯命令
    LightOnCommand lightOnCommand = new LightOnCommand(bedroomLight);
    LightOffCommand lightOffCommand = new LightOffCommand(bedroomLight);
    remoteController.setCommand(0, lightOnCommand, lightOffCommand);

    // 音响命令
    StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
    StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
    remoteController.setCommand(1, stereoOnCommand, stereoOffCommand);

    remoteController.buttonOn(0);
    remoteController.buttonOn(1);

    remoteController.buttonOff(0);
    remoteController.buttonOff(1);

    log.info("开始撤销上一步操作");
    // 撤销上一步操作
    remoteController.undo();
    remoteController.undo();
  }

  // 宏命令的demo
  private static void macroCommandDemo() {
    // 遥控器
    RemoteController remoteController = new RemoteController(1);
    // 灯
    Light bedroom = new Light("卧室灯");
    // 台灯
    Light desk = new Light("台灯");
    // 音响
    Stereo stereo = new Stereo("音响");

    // 灯命令
    LightOnCommand bedroomOn = new LightOnCommand(bedroom);
    LightOffCommand bedroomOff = new LightOffCommand(bedroom);
    LightOnCommand deskOn = new LightOnCommand(desk);
    LightOffCommand deskOff = new LightOffCommand(desk);

    // 音响命令
    StereoOnCommand stereoOn = new StereoOnCommand(stereo);
    StereoOffCommand stereoOff = new StereoOffCommand(stereo);

    // 宏命令
    MacroCommand macroOn = new MacroCommand(new Command[]{bedroomOn, deskOn, stereoOn});
    MacroCommand macroOff = new MacroCommand(new Command[]{bedroomOff, deskOff, stereoOff});

    // 设置宏命令
    remoteController.setCommand(0, macroOn, macroOff);

    // 调用开启
    remoteController.buttonOn(0);
    // 调用关闭
    remoteController.buttonOff(0);

    // 撤销操作
    log.warn("=== 撤销操作 ===");
    remoteController.undo();
  }
}
