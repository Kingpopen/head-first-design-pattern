package com.kingpopen.factorypattern.abstractfactory.ingredient.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Dough;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 细面团
 * @date 2024/3/3 20:18:01
 */
@Getter
public class ThinDough implements Dough {
  private String name;

  public ThinDough(){
    this.name = "细面团";
  }
}
