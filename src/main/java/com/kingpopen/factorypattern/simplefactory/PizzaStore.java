package com.kingpopen.factorypattern.simplefactory;

import lombok.AllArgsConstructor;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 披萨商店
 * @date 2024/3/3 14:04:05
 */
@AllArgsConstructor
public class PizzaStore {
  private SimplePizzaFactory pizzaFactory;

  public Pizza orderPizza(String type){
    // 将pizza的实例化过程交给工厂实现
    Pizza pizza = pizzaFactory.createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }
}
