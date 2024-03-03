package com.kingpopen.factorypattern.simplefactory.impl;

import com.kingpopen.factorypattern.simplefactory.Pizza;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description greekPizza
 * @date 2024/3/3 14:01:30
 */
@Slf4j
public class GreekPizza implements Pizza {
  @Override
  public void prepare() {
    log.info("Greek pizza 正在准备！");
  }

  @Override
  public void bake() {
    log.info("Greek pizza 正在烘培！");
  }

  @Override
  public void cut() {
    log.info("Greek pizza 正在切割！");
  }

  @Override
  public void box() {
    log.info("Greek pizza 正在装盒！");
  }
}
