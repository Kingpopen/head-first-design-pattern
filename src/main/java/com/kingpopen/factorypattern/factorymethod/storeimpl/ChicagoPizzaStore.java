package com.kingpopen.factorypattern.factorymethod.storeimpl;

import com.kingpopen.factorypattern.factorymethod.AbstractPizzaStore;
import com.kingpopen.factorypattern.factorymethod.Pizza;
import com.kingpopen.factorypattern.factorymethod.pizzaimpl.ChicagoCheesePizza;
import com.kingpopen.factorypattern.factorymethod.pizzaimpl.ChicagoGreekPizza;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description
 * @date 2024/3/3 14:37:39
 */
public class ChicagoPizzaStore extends AbstractPizzaStore {

  @Override
  protected Pizza createPizza(String type) {
    if ("Cheese".equals(type)){
      return new ChicagoCheesePizza();
    }else if ("greek".equals(type)){
      return new ChicagoGreekPizza();
    }else{
      throw new IllegalArgumentException("参数错误!");
    }
  }
}
