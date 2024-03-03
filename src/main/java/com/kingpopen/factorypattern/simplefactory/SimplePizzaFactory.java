package com.kingpopen.factorypattern.simplefactory;

import com.kingpopen.factorypattern.simplefactory.impl.CheesePizza;
import com.kingpopen.factorypattern.simplefactory.impl.GreekPizza;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 简单pizza工厂
 * @date 2024/3/3 14:05:06
 */
public class SimplePizzaFactory {
  public Pizza createPizza(String type){
    if ("Cheese".equals(type)){
      return new CheesePizza();
    }else if ("greek".equals(type)){
      return new GreekPizza();
    }else {
      throw new IllegalArgumentException("参数错误!");
    }
  }
}
