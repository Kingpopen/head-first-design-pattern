package com.kingpopen.statepattern.impl;

import com.kingpopen.statepattern.GumballMachine;
import com.kingpopen.statepattern.State;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 没有钱的状态
 * @date 2024/3/16 12:35:24
 */
@Slf4j
@AllArgsConstructor
public class NoQuarterState implements State {

  private GumballMachine gumballMachine;

  @Override
  public void insertQuarter() {
    log.info("正在收取您的25美分!");
    gumballMachine.setCurStateToHasQuarterState();
    log.info("收取成功！");
  }

  @Override
  public void ejectQuarter() {
    log.info("你还没有投币，请先投币！");
  }

  @Override
  public boolean turnCrank() {
    log.info("你还没有投币，请先投币！");
    return false;
  }

  @Override
  public void dispense() {
    log.info("请先投币！");
  }
}
