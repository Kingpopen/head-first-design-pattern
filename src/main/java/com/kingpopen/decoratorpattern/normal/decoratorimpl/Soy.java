package com.kingpopen.decoratorpattern.normal.decoratorimpl;

import com.kingpopen.decoratorpattern.normal.Beverage;
import com.kingpopen.decoratorpattern.normal.CondimentDecorator;
import com.kingpopen.decoratorpattern.normal.enums.SizeEnum;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 调料: 大豆
 * @date 2024/02/26 22:06:16
 */
public class Soy extends CondimentDecorator {

  public Soy(Beverage beverage) {
    super(beverage);
    description = "大豆";
  }

  public Soy(Beverage beverage, SizeEnum sizeEnum){
    super(beverage);
    description = "大豆";
    this.sizeEnum = sizeEnum;
  }

  @Override
  public double cost() {
    double price = 0.00;
    if (sizeEnum == SizeEnum.SMALL){
      price = 0.10;
    } else if (sizeEnum == SizeEnum.Middle){
      price = 0.30;
    } else if (sizeEnum == SizeEnum.BIG){
      price = 0.40;
    }else{
      throw new IllegalArgumentException("调料:大豆 参数错误:" + sizeEnum.getSize());
    }
    return price + beverage.cost();
  }

  @Override
  public String getDescription() {
    return sizeEnum.getSize() + description + beverage.getDescription();
  }
}
