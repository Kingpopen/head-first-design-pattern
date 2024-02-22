package com.kingpopen.strategypattern.impl;

import com.kingpopen.strategypattern.Character;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 骑士
 * @date 2024/02/19 22:17:22
 */
public class Knight extends Character {

  @Override
  public void fight() {
    System.out.print("骑士:");
    behavior.useWeapon();
  }
}
