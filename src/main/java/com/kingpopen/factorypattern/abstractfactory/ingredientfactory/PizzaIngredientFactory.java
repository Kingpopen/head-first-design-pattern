package com.kingpopen.factorypattern.abstractfactory.ingredientfactory;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Cheese;
import com.kingpopen.factorypattern.abstractfactory.ingredient.Clam;
import com.kingpopen.factorypattern.abstractfactory.ingredient.Dough;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description pizza的原材料工厂
 * @date 2024/3/3 20:29:15
 */
public interface PizzaIngredientFactory {
  // 创建面团
  Dough createDough();

  // 创建奶酪
  Cheese createCheese();

  Clam createClam();
}
