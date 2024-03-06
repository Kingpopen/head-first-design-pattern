package com.kingpopen.commandpattern.impl;

import com.kingpopen.commandpattern.Command;
import com.kingpopen.commandpattern.Light;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 灯开启的命令
 * @date 2024/03/06 22:09:13
 */
@Getter
@AllArgsConstructor
public class LightOnCommand implements Command {

  private Light light;


  @Override
  public void execute() {
    light.on();
  }

  @Override
  public void undo() {
    light.off();
  }
}
