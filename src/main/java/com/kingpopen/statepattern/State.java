package com.kingpopen.statepattern;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 状态类
 * @date 2024/3/16 12:22:39
 */
public interface State {

  // 放入钱
  void insertQuarter();

  // 退钱
  void ejectQuarter();

  // 转动曲柄
  boolean turnCrank();

  // 发放糖果
  void dispense();
}
