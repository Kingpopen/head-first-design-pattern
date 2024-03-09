package com.kingpopen.facadepattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 零食
 * @date 2024/3/9 21:34:32
 */
@Slf4j
public class Food {
  public void buy() {
    log.info("买零食");
  }

  public void eat() {
    log.info("吃零食");
  }

  public void end() {
    log.info("结束吃零食");
  }
}
