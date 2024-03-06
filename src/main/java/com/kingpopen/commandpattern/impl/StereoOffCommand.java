package com.kingpopen.commandpattern.impl;

import com.kingpopen.commandpattern.Command;
import com.kingpopen.commandpattern.Stereo;
import lombok.AllArgsConstructor;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 音响关闭
 * @date 2024/03/06 22:22:55
 */
@AllArgsConstructor
public class StereoOffCommand implements Command {

  private Stereo stereo;

  @Override
  public void execute() {
    stereo.off();
  }

  @Override
  public void undo() {
    stereo.on();
  }
}
