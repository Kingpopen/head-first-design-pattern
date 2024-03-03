package com.kingpopen.factorypattern.abstractfactory.ingredientfactory.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Cheese;
import com.kingpopen.factorypattern.abstractfactory.ingredient.Clam;
import com.kingpopen.factorypattern.abstractfactory.ingredient.Dough;
import com.kingpopen.factorypattern.abstractfactory.ingredient.impl.FreshClam;
import com.kingpopen.factorypattern.abstractfactory.ingredient.impl.MozzarellaCheese;
import com.kingpopen.factorypattern.abstractfactory.ingredient.impl.ThickDough;
import com.kingpopen.factorypattern.abstractfactory.ingredientfactory.PizzaIngredientFactory;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 纽约pizza的原材料工厂
 * @date 2024/3/3 20:31:02
 */
public class NYIngredientFactory implements PizzaIngredientFactory {


  @Override
  public Dough createDough() {
    return new ThickDough();
  }

  @Override
  public Cheese createCheese() {
    return new MozzarellaCheese();
  }

  @Override
  public Clam createClam() {
    return new FreshClam();
  }
}
