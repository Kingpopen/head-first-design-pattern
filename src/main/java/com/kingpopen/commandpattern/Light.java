package com.kingpopen.commandpattern;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 灯类
 * @date 2024/03/06 22:07:37
 */
@Slf4j
@ToString
@AllArgsConstructor
public class Light {

  private String name;

  public void on() {
    log.info("{}  is on", name);
  }

  public void off() {
    log.info("{} is off", name);
  }
}
