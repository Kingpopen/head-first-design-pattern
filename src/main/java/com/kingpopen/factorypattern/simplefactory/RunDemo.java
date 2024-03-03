package com.kingpopen.factorypattern.simplefactory;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/3/3 14:16:55
 */
public class RunDemo {

  public static void main(String[] args) {
    // 创建工厂的时候还是面向了实现
    PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
    pizzaStore.orderPizza("Cheese");
  }
}
