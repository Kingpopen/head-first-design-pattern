package com.kingpopen.statepattern.impl;

import com.kingpopen.statepattern.GumballMachine;
import com.kingpopen.statepattern.State;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 卖完了的状态
 * @date 2024/3/16 14:01:20
 */
@Slf4j
@AllArgsConstructor
public class SoldOutState implements State {

  private GumballMachine gumballMachine;

  @Override
  public void insertQuarter() {
    log.info("对不起，糖果已经卖完了！");
  }

  @Override
  public void ejectQuarter() {
    log.info("对不起，糖果已经卖完了！");
  }

  @Override
  public boolean turnCrank() {
    log.info("对不起，糖果已经卖完了！");
    return false;
  }

  @Override
  public void dispense() {
    log.info("对不起，糖果已经卖完了！");
  }
}
