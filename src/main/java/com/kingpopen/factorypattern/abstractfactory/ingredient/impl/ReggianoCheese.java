package com.kingpopen.factorypattern.abstractfactory.ingredient.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Cheese;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description reggiano 奶酪
 * @date 2024/3/3 20:26:19
 */
@Getter
public class ReggianoCheese implements Cheese {
  private String name;

  public ReggianoCheese(){
    this.name = "帕玛森奶酪";
  }
}
