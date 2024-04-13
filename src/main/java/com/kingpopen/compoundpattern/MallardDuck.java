package com.kingpopen.compoundpattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 绿头鸭
 * @date 2024/4/13 19:39:45
 */
@Slf4j
public class MallardDuck implements Quackable{

  @Override
  public void quack() {
    log.info("绿头鸭 嘎嘎叫!");
  }
}
