package com.kingpopen.factorypattern.abstractfactory.ingredientfactory.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Cheese;
import com.kingpopen.factorypattern.abstractfactory.ingredient.Clam;
import com.kingpopen.factorypattern.abstractfactory.ingredient.Dough;
import com.kingpopen.factorypattern.abstractfactory.ingredient.impl.FrozenClam;
import com.kingpopen.factorypattern.abstractfactory.ingredient.impl.ReggianoCheese;
import com.kingpopen.factorypattern.abstractfactory.ingredient.impl.ThinDough;
import com.kingpopen.factorypattern.abstractfactory.ingredientfactory.PizzaIngredientFactory;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 芝加哥pizza原材料工厂
 * @date 2024/3/3 20:34:06
 */
public class ChicagoIngredientFactory implements PizzaIngredientFactory {

  @Override
  public Dough createDough() {
    return new ThinDough();
  }

  @Override
  public Cheese createCheese() {
    return new ReggianoCheese();
  }

  @Override
  public Clam createClam() {
    return new FrozenClam();
  }
}
