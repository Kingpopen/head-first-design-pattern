package com.kingpopen.commandpattern;

import java.util.Optional;
import java.util.Stack;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 遥控器
 * @date 2024/03/06 22:24:47
 */
@Slf4j
public class RemoteController {

  // 命令集合
  private final Command[] onCommands;
  private final Command[] offCommands;

  // 使用stack存储command
  private Stack<Command> undoCommands;


  public RemoteController(int num) {
    onCommands = new Command[num];
    offCommands = new Command[num];
    undoCommands = new Stack<>();
  }

  // 设置命令
  public void setCommand(int slot, Command onCommand, Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  // 打开开关
  public void buttonOn(int slot) {
    // 判断是否越界
    if (slot >= onCommands.length) {
      log.warn("slot out of range!");
      return;
    }
    // 部分onCommand可能为空 使用Optional进行包装处理
    Optional.of(onCommands[slot]).ifPresent(command -> {
      command.execute();
      undoCommands.push(onCommands[slot]);
    });
  }

  public void buttonOff(int slot) {
    // 判断是否越界
    if (slot >= offCommands.length) {
      log.warn("slot out of range!");
      return;
    }

    // 部分offCommand可能为空 使用Optional进行包装处理
    Optional.of(offCommands[slot]).ifPresent(command -> {
      command.execute();
      undoCommands.push(offCommands[slot]);
    });
  }

  // undo
  public void undo() {
    if (undoCommands.isEmpty()){
      log.warn("no command to undo!");
      return;
    }
    Optional.of(undoCommands.pop()).ifPresent(Command::undo);
  }
}
