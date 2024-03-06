package com.kingpopen.commandpattern;

import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 音响
 * @date 2024/03/06 22:15:50
 */
@Slf4j
@Setter
@ToString
public class Stereo {

  private String name;
  private String cd;
  private Integer volume;

  public void on() {
    // log 打印 stereo on
    log.info("stereo on");
  }

  public void off() {
    // log 打印 stereo off
    log.info("stereo off");
  }
}
