package com.kingpopen.statepattern.impl;

import com.kingpopen.statepattern.GumballMachine;
import com.kingpopen.statepattern.State;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 卖产品
 * @date 2024/3/16 12:35:52
 */
@Slf4j
@AllArgsConstructor
public class SoldState implements State {

  private GumballMachine gumballMachine;

  @Override
  public void insertQuarter() {
    log.info("已经放入过钱了，请勿重复放入！");
  }

  @Override
  public void ejectQuarter() {
    log.info("对不起，你已经转动了旋转按钮，无法退钱！");
  }

  @Override
  public boolean turnCrank() {
    log.info("你已经转动了旋转按钮，正在出货中，请勿重复转动！");
    return false;
  }

  @Override
  public void dispense() {
    // 1. 进行出货
    if (gumballMachine.getCount() > 0) {
      log.info("正在出货中，请稍等！");
      gumballMachine.releaseBall();
      log.info("出货成功！");
    } else {
      log.info("对不起，糖果已经卖完了！");
      gumballMachine.setCurStateToSoldOutState();
      return;
    }
    // 2. 已经出货成功之后的状态
    if (gumballMachine.getCount() > 0) {
      gumballMachine.setCurStateToNoQuarterState();
    } else {
      gumballMachine.setCurStateToSoldOutState();
    }
  }
}
