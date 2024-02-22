package com.kingpopen.strategypattern.impl;

import com.kingpopen.strategypattern.WeaponBehavior;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 宝剑
 * @date 2024/02/19 22:25:29
 */
public class SwordBehavior implements WeaponBehavior {

  @Override
  public void useWeapon() {
    System.out.println("使用宝剑！");
  }
}
