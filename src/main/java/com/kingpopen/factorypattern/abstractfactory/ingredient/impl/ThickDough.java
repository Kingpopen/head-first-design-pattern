package com.kingpopen.factorypattern.abstractfactory.ingredient.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Dough;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 厚面团
 * @date 2024/3/3 20:15:40
 */
@Getter
public class ThickDough implements Dough {
  private String name;

  public ThickDough(){
    this.name = "厚面团";
  }
}
