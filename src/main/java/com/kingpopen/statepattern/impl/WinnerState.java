package com.kingpopen.statepattern.impl;

import com.kingpopen.statepattern.GumballMachine;
import com.kingpopen.statepattern.State;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 赢家状态
 * @date 2024/3/16 14:01:52
 */
@Slf4j
@AllArgsConstructor
public class WinnerState implements State {

  private GumballMachine gumballMachine;

  @Override
  public void insertQuarter() {
    log.info("你已经投入过25美分，请勿重复投币！");
  }

  @Override
  public void ejectQuarter() {
    log.info("你已经转动了旋转按钮，无法退钱！");
  }

  @Override
  public boolean turnCrank() {
    log.info("你已经转动了旋转按钮，请等待出货!");
    return false;
  }

  @Override
  public void dispense() {
    if (gumballMachine.getCount() > 0) {
      // 发放糖果
      gumballMachine.releaseBall();
      if (gumballMachine.getCount() > 0) {
        log.info("==== 恭喜你，你是赢家，你可以多获取1颗糖果！ ====");
        gumballMachine.releaseBall();
      }
      log.info("糖果已经发放，请注意查收！");
    } else {
      log.info("对不起，糖果已经卖完了！");
      gumballMachine.setCurStateToSoldState();
      return;
    }
    if (gumballMachine.getCount() == 0) {
      gumballMachine.setCurStateToSoldOutState();
    } else {
      gumballMachine.setCurStateToNoQuarterState();
    }
  }
}
