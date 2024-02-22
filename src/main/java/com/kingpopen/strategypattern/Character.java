package com.kingpopen.strategypattern;

import lombok.Setter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 角色类
 * @date 2024/02/19 22:11:28
 */
@Setter
public abstract class Character {
  protected WeaponBehavior behavior;

  // 攻击
  abstract public void fight();
}
