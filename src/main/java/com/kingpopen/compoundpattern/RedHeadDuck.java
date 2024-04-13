package com.kingpopen.compoundpattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 红头鸭
 * @date 2024/4/13 19:40:43
 */
@Slf4j
public class RedHeadDuck implements Quackable{

  @Override
  public void quack() {
    log.info("红头鸭 嘎嘎叫!");
  }
}
