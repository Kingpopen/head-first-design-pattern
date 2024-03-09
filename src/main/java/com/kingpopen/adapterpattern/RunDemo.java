package com.kingpopen.adapterpattern;

import com.kingpopen.adapterpattern.adaptee.Turkey;
import com.kingpopen.adapterpattern.adapter.TurkeyAdapter;
import com.kingpopen.adapterpattern.target.Duck;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/3/9 19:05:37
 */
public class RunDemo {

  public static void main(String[] args) {
   adapterDemo();
  }

  // demo
  private static void adapterDemo(){
    // 创建火鸡
    Turkey turkey = new Turkey();
    // 创建鸭子的适配器 并传入火鸡
    Duck duck = new TurkeyAdapter(turkey);

    // 调用适配器的方法
    duck.quack();
  }
}
