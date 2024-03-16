package com.kingpopen.statepattern.impl;

import com.kingpopen.statepattern.GumballMachine;
import com.kingpopen.statepattern.State;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 有25美分的状态
 * @date 2024/3/16 12:26:07
 */
@Slf4j
@AllArgsConstructor
public class HasQuarterState implements State {

  private GumballMachine gumballMachine;

  @Override
  public void insertQuarter() {
    log.info("已经收到你的投币!");
  }

  @Override
  public void ejectQuarter() {
    log.info("好的正在给你处理退钱手续，请等待!");
    gumballMachine.setCurStateToNoQuarterState();
    log.info("退钱成功！");
  }

  @Override
  public boolean turnCrank() {
    log.info("转动旋转按钮，准备发放糖果！");
    // 判断是否为赢家
    if (judgeWinner()) {
      gumballMachine.setCurStateToWinnerState();
    }else{
      gumballMachine.setCurStateToSoldState();
    }
    return true;
  }

  @Override
  public void dispense() {
    log.info("请先转动旋转按钮！");
  }

  private boolean judgeWinner() {
    return Math.random() < 0.1;
  }
}
