package com.kingpopen.factorypattern.abstractfactory.ingredient.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Clam;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 冻蛤俐
 * @date 2024/3/3 21:04:04
 */
@Getter
public class FrozenClam implements Clam {
  private String name;

  public FrozenClam(){
    this.name = "冻蛤俐";
  }
}
