package com.kingpopen.statepattern;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/3/16 12:19:47
 */
public class RunDemo {

  public static void main(String[] args) {
    GumballMachine gumBallMachine = new GumballMachine();
    // 放入糖果
    gumBallMachine.fill(2);
    // 放入钱
    gumBallMachine.insertQuarter();
    // 转动
    gumBallMachine.turnCrank();

    gumBallMachine.insertQuarter();
    gumBallMachine.turnCrank();

    gumBallMachine.insertQuarter();
    gumBallMachine.turnCrank();
  }
}
