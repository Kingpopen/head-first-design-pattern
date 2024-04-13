package com.kingpopen.compoundpattern.strategy;

import com.kingpopen.compoundpattern.MallardDuck;
import com.kingpopen.compoundpattern.Quackable;
import com.kingpopen.compoundpattern.RedHeadDuck;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 鸭子模拟器
 * @date 2024/4/13 19:42:03
 */
public class DuckSimulator {

  public static void main(String[] args) {
    Quackable mallardDuck = new MallardDuck();
    Quackable redHeadDuck = new RedHeadDuck();

    // 1. 策略模式 (通过new 不同的策略执行不同的效果)
    simulate(mallardDuck);
    simulate(redHeadDuck);
  }

  private static void simulate(Quackable duck) {
    duck.quack();
  }
}
