package com.kingpopen.factorypattern.simplefactory.impl;

import com.kingpopen.factorypattern.simplefactory.Pizza;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description cheese披萨
 * @date 2024/3/3 13:59:28
 */
@Slf4j
public class CheesePizza implements Pizza {

  @Override
  public void prepare() {
    log.info("Cheese pizza 正在准备！");
  }

  @Override
  public void bake() {
    log.info("Cheese pizza 正在烘培！");
  }

  @Override
  public void cut() {
    log.info("Cheese pizza 正在切割！");
  }

  @Override
  public void box() {
    log.info("Cheese pizza 正在装盒！");
  }
}
