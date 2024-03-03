package com.kingpopen.factorypattern.abstractfactory.store.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Clam;
import com.kingpopen.factorypattern.abstractfactory.ingredientfactory.PizzaIngredientFactory;
import com.kingpopen.factorypattern.abstractfactory.pizza.Pizza;
import com.kingpopen.factorypattern.abstractfactory.ingredientfactory.impl.NYIngredientFactory;
import com.kingpopen.factorypattern.abstractfactory.pizza.impl.CheesePizza;
import com.kingpopen.factorypattern.abstractfactory.pizza.impl.ClamPizza;
import com.kingpopen.factorypattern.abstractfactory.store.AbstractPizzaStore;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 纽约pizza店
 * @date 2024/3/3 20:46:34
 */
public class NyPizzaStore extends AbstractPizzaStore {

  @Override
  protected Pizza createPizza(String type) {
    PizzaIngredientFactory ingredientFactory = new NYIngredientFactory();

    if ("cheese".equals(type)){
      return new CheesePizza("纽约的芝士披萨", ingredientFactory);
    }else if ("clam".equals(type)){
      return new ClamPizza("纽约的蛤俐披萨", ingredientFactory);
    }else{
      throw new IllegalArgumentException("参数错误!");
    }
  }
}
