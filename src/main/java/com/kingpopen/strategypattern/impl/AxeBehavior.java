package com.kingpopen.strategypattern.impl;

import com.kingpopen.strategypattern.WeaponBehavior;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 斧头
 * @date 2024/02/19 22:24:35
 */
public class AxeBehavior implements WeaponBehavior {

  @Override
  public void useWeapon() {
    System.out.println("使用斧头！");
  }
}
