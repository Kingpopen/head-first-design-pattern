package com.kingpopen.factorypattern.factorymethod.pizzaimpl;

import com.kingpopen.factorypattern.factorymethod.Pizza;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description
 * @date 2024/3/3 14:30:47
 */
@Slf4j
public class ChicagoGreekPizza implements Pizza {
  @Override
  public void prepare() {
    log.info("ChicagoGreek pizza 正在准备！");
  }

  @Override
  public void bake() {
    log.info("ChicagoGreek pizza 正在烘培！");
  }

  @Override
  public void cut() {
    log.info("ChicagoGreek pizza 正在切割！");
  }

  @Override
  public void box() {
    log.info("ChicagoGreek pizza 正在装盒！");
  }

}
