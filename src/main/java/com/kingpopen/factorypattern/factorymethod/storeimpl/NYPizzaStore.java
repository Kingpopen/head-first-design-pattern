package com.kingpopen.factorypattern.factorymethod.storeimpl;


import com.kingpopen.factorypattern.factorymethod.AbstractPizzaStore;
import com.kingpopen.factorypattern.factorymethod.Pizza;
import com.kingpopen.factorypattern.factorymethod.pizzaimpl.NYCheesePizza;
import com.kingpopen.factorypattern.factorymethod.pizzaimpl.NYGreekPizza;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description
 * @date 2024/3/3 14:35:14
 */
public class NYPizzaStore extends AbstractPizzaStore {

  @Override
  protected Pizza createPizza(String type) {
    if ("Cheese".equals(type)){
      return new NYCheesePizza();
    }else if ("greek".equals(type)){
      return new NYGreekPizza();
    }else{
      throw new IllegalArgumentException("参数错误!");
    }
  }
}
