package com.kingpopen.statepattern;

import com.kingpopen.statepattern.impl.HasQuarterState;
import com.kingpopen.statepattern.impl.NoQuarterState;
import com.kingpopen.statepattern.impl.SoldOutState;
import com.kingpopen.statepattern.impl.SoldState;
import com.kingpopen.statepattern.impl.WinnerState;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 糖果机器
 * @date 2024/3/16 12:27:09
 */
public class GumballMachine {

  // 未投币状态
  private State noQuarterState = new NoQuarterState(this);
  // 已投币状态
  private State hasQuarterState = new HasQuarterState(this);
  // 出售状态
  private State soldState = new SoldState(this);
  // 卖完状态
  private State soldOutState = new SoldOutState(this);
  // 赢家状态
  private State winnerState = new WinnerState(this);

  // 当前的状态
  private State curState;

  // 糖果数目
  private int count;

  // 放入钱
  public void insertQuarter() {
    this.curState.insertQuarter();
  }

  // 取钱
  public void ejectQuarter() {
    this.curState.ejectQuarter();
  }

  // 转动曲柄
  public void turnCrank() {
    if (this.curState.turnCrank()){
      this.curState.dispense();
    }
  }


  // 补充糖果
  public void fill(final int count) {
    this.count += count;
    if (count > 0) {
      this.curState = noQuarterState;
    } else {
      this.curState = noQuarterState;
    }
  }

  // 设置当前状态 为 未投币状态
  public void setCurStateToNoQuarterState() {
    this.curState = noQuarterState;
  }

  // 设置当前状态 为 已投币状态
  public void setCurStateToHasQuarterState() {
    this.curState = hasQuarterState;
  }

  // 设置当前状态为 出售状态
  public void setCurStateToSoldState() {
    this.curState = soldState;
  }

  // 设置当前状态为 卖完状态
  public void setCurStateToSoldOutState() {
    this.curState = soldOutState;
  }

  // 设置当前状态为赢家
  public void setCurStateToWinnerState() {
    this.curState = winnerState;
  }

  public int getCount() {
    return count;
  }

  // 出货
  public void releaseBall() {
    if (count != 0) {
      count -= 1;
    }
  }
}
