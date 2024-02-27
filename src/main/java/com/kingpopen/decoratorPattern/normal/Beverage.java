package com.kingpopen.decoratorPattern.normal;

import com.kingpopen.decoratorPattern.normal.enums.SizeEnum;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 饮料基类
 * @date 2024/02/26 21:53:53
 */
public abstract class Beverage {
  protected String description = "unknow beverage";
  protected SizeEnum sizeEnum;

  public String getDescription(){
    return sizeEnum.getSize() + description;
  }

  public abstract double cost();


}
