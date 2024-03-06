package com.kingpopen.commandpattern.impl;

import com.kingpopen.commandpattern.Command;
import com.kingpopen.commandpattern.Stereo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 音响打开
 * @date 2024/03/06 22:19:08
 */
@Getter
@AllArgsConstructor
public class StereoOnCommand implements Command {

  private Stereo stereo;


  @Override
  public void execute() {
    stereo.on();
    stereo.setCd("枫");
    stereo.setVolume(11);
  }

  @Override
  public void undo() {
    stereo.off();
  }

}
