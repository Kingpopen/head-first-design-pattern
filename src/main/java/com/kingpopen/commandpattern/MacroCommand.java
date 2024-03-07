package com.kingpopen.commandpattern;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 宏命令
 * @date 2024/03/07 22:20:16
 */
@Slf4j
@AllArgsConstructor
public class MacroCommand implements Command{
  private Command[] commands;
  @Override
  public void execute() {
    for (Command command : commands) {
      command.execute();
    }
  }

  @Override
  public void undo() {
    // 反向出输出undo操作
    for (int i = commands.length - 1; i >= 0; i--) {
      commands[i].undo();
    }
  }
}
