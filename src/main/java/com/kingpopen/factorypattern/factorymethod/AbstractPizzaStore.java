package com.kingpopen.factorypattern.factorymethod;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description pizza商店
 * @date 2024/3/3 14:24:57
 */
public abstract class AbstractPizzaStore {
  protected abstract Pizza createPizza(String type);

  // 模版方法
  public Pizza orderPizza(String type){
    final Pizza pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }
}
