package com.kingpopen.strategypattern.impl;

import com.kingpopen.strategypattern.Character;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 女王
 * @date 2024/02/19 22:13:24
 */
public class Queen extends Character {

  @Override
  public void fight() {
    System.out.print("女王:");
    behavior.useWeapon();
  }
}
