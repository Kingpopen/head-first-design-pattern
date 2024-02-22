package com.kingpopen.strategypattern;

import com.kingpopen.strategypattern.impl.King;
import com.kingpopen.strategypattern.impl.KnifeBehavior;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行
 * @date 2024/02/19 22:30:41
 */
public class RunDemo {

  public static void main(String[] args) {
    Character king = new King();
    king.fight();

    // 换装备
    System.out.println("换装备......");
    king.setBehavior(new KnifeBehavior());
    king.fight();
  }
}
