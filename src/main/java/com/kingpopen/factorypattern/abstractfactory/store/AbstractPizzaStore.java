package com.kingpopen.factorypattern.abstractfactory.store;

import com.kingpopen.factorypattern.abstractfactory.pizza.Pizza;
import com.kingpopen.factorypattern.abstractfactory.ingredientfactory.PizzaIngredientFactory;
import lombok.AllArgsConstructor;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 抽象的披萨店
 * @date 2024/3/3 20:43:17
 */
@AllArgsConstructor
public abstract class AbstractPizzaStore {

  protected abstract Pizza createPizza(String type);

  public Pizza orderPizza(String type){
    Pizza pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

}
