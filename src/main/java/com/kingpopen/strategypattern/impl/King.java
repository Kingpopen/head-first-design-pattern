package com.kingpopen.strategypattern.impl;

import com.kingpopen.strategypattern.Character;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 王国
 * @date 2024/02/19 22:14:33
 */
public class King extends Character {

  public King(){
    behavior = new SwordBehavior();
  }

  @Override
  public void fight() {
    System.out.print("国王:");
    behavior.useWeapon();
  }
}
