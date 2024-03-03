package com.kingpopen.factorypattern.abstractfactory.ingredient.impl;

import com.kingpopen.factorypattern.abstractfactory.ingredient.Clam;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 新鲜蛤俐
 * @date 2024/3/3 21:09:12
 */
@Getter
public class FreshClam implements Clam {
  private String name;

  public FreshClam(){
    this.name = "新鲜蛤俐";
  }
}
