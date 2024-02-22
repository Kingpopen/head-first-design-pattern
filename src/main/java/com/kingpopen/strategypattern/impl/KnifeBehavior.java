package com.kingpopen.strategypattern.impl;

import com.kingpopen.strategypattern.WeaponBehavior;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 小刀
 * @date 2024/02/19 22:22:58
 */
public class KnifeBehavior implements WeaponBehavior {

  @Override
  public void useWeapon() {
    System.out.println("使用小刀！");
  }
}
