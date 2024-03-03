package com.kingpopen.factorypattern.abstractfactory.ingredient.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Cheese;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 莫扎纳奶酪
 * @date 2024/3/3 20:19:33
 */
@Getter
public class MozzarellaCheese implements Cheese {
  private String name;

  public MozzarellaCheese(){
    this.name = "莫扎纳奶酪";
  }
}
