package com.kingpopen.compoundpattern.factory;

import com.kingpopen.compoundpattern.Quackable;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 抽象工厂
 * @date 2024/4/13 22:14:03
 */
public interface AbstractFactory {
  // 创建绿头鸭
  Quackable createMallardDuck();

  // 创建红头鸭
  Quackable createRedDuck();

  // 创建适配器鸭子
  Quackable createAdapterDuck();
}
