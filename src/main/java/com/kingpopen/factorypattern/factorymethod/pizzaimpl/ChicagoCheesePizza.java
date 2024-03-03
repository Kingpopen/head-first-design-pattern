package com.kingpopen.factorypattern.factorymethod.pizzaimpl;

import com.kingpopen.factorypattern.factorymethod.Pizza;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description
 * @date 2024/3/3 14:28:34
 */
@Slf4j
public class ChicagoCheesePizza implements Pizza {
  @Override
  public void prepare() {
    log.info("ChicagoCheese pizza 正在准备！");
  }

  @Override
  public void bake() {
    log.info("ChicagoCheese pizza 正在烘培！");
  }

  @Override
  public void cut() {
    log.info("ChicagoCheese pizza 正在切割！");
  }

  @Override
  public void box() {
    log.info("ChicagoCheese pizza 正在装盒！");
  }
}
