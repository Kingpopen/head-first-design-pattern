package com.kingpopen.facadepattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 电视
 * @date 2024/3/9 21:33:08
 */
@Slf4j
public class TV {
  public void on() {
    log.info("打开电视");
  }

  public void off() {
    log.info("关闭电视");
  }
}
