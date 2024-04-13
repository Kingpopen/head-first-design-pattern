package com.kingpopen.compoundpattern.decorator;

import com.kingpopen.compoundpattern.Quackable;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 鸭子叫声装饰器 装饰器模式和适配器模式很像
 * @date 2024/4/13 19:54:18
 */
public class QuackCountDecorator implements Quackable {
  // static 的类型，属于类的内容，该类的所有对象都共享
  @Getter
  private static int count = 0;
  private Quackable duck;

  public QuackCountDecorator(Quackable duck){
    this.duck = duck;
  }

  @Override
  public void quack() {
    count += 1;
    duck.quack();
  }
}
