package com.kingpopen.factorypattern.abstractfactory.pizza.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredientfactory.PizzaIngredientFactory;
import com.kingpopen.factorypattern.abstractfactory.pizza.Pizza;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 蛤俐披萨
 * @date 2024/3/3 21:19:25
 */
@Slf4j
public class ClamPizza extends Pizza {
  private PizzaIngredientFactory pizzaIngredientFactory;

  public ClamPizza(String name, PizzaIngredientFactory pizzaIngredientFactory){
    setName(name);
    this.pizzaIngredientFactory = pizzaIngredientFactory;
  }

  @Override
  public void prepare() {
    setClam(pizzaIngredientFactory.createClam());
    setDough(pizzaIngredientFactory.createDough());
    log.info("准备的材料是:{} {}", getClam().getName(), getDough().getName());
  }
}
