package com.kingpopen.factorypattern.abstractfactory.pizza;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Cheese;
import com.kingpopen.factorypattern.abstractfactory.ingredient.Clam;
import com.kingpopen.factorypattern.abstractfactory.ingredient.Dough;
import com.kingpopen.factorypattern.abstractfactory.ingredientfactory.PizzaIngredientFactory;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description Pizza抽象类
 * @date 2024/3/3 20:10:25
 */
@Data
@Slf4j
public abstract class Pizza {
  // 名称
  private String name;
  // 面团
  private Dough dough;
  // 奶酪
  private Cheese cheese;
  // 蛤俐
  private Clam clam;

  // 准备
  public abstract void prepare();

  public void bake(){
    log.info("进行烘培!");
  }

  public void cut(){
    log.info("进行切割!");
  }

  public void box(){
    log.info("进行装盘!");
  }

}
