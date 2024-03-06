package com.kingpopen.commandpattern.impl;

import com.kingpopen.commandpattern.Command;
import com.kingpopen.commandpattern.Light;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 灯关闭
 * @date 2024/03/06 22:17:35
 */
@Getter
@AllArgsConstructor
public class LightOffCommand implements Command {

  private Light light;

  @Override
  public void execute() {
    light.off();
  }

  @Override
  public void undo() {
    light.on();
  }
}
