package com.kingpopen.factorypattern.abstractfactory.pizza.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredientfactory.PizzaIngredientFactory;
import com.kingpopen.factorypattern.abstractfactory.pizza.Pizza;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 芝士披萨
 * @date 2024/3/3 21:12:13
 */
@Slf4j
public class CheesePizza extends Pizza {

  private PizzaIngredientFactory ingredientFactory;

  public CheesePizza(String name, PizzaIngredientFactory ingredientFactory){
    setName(name);
    this.ingredientFactory = ingredientFactory;
  }

  @Override
  public void prepare() {
    setCheese(ingredientFactory.createCheese());
    setDough(ingredientFactory.createDough());
    log.info("准备的材料是:{} {}", getCheese().getName(), getDough().getName());
  }
}
