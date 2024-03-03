package com.kingpopen.factorypattern.abstractfactory.store.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredientfactory.PizzaIngredientFactory;
import com.kingpopen.factorypattern.abstractfactory.ingredientfactory.impl.ChicagoIngredientFactory;
import com.kingpopen.factorypattern.abstractfactory.pizza.Pizza;
import com.kingpopen.factorypattern.abstractfactory.pizza.impl.CheesePizza;
import com.kingpopen.factorypattern.abstractfactory.pizza.impl.ClamPizza;
import com.kingpopen.factorypattern.abstractfactory.store.AbstractPizzaStore;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 芝加哥披萨店
 * @date 2024/3/3 21:29:21
 */
public class ChicagoPizzaStore extends AbstractPizzaStore {

  @Override
  protected Pizza createPizza(String type) {
    PizzaIngredientFactory pizzaIngredientFactory = new ChicagoIngredientFactory();

    if ("cheese".equals(type)){
      return new CheesePizza("芝加哥的芝士披萨", pizzaIngredientFactory);
    }else if ("clam".equals(type)){
      return new ClamPizza("芝加哥的蛤俐披萨", pizzaIngredientFactory);
    }else {
      throw new IllegalArgumentException("参数错误!");
    }
  }
}
