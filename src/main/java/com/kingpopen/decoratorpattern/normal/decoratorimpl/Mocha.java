package com.kingpopen.decoratorpattern.normal.decoratorimpl;

import com.kingpopen.decoratorpattern.normal.Beverage;
import com.kingpopen.decoratorpattern.normal.CondimentDecorator;
import com.kingpopen.decoratorpattern.normal.enums.SizeEnum;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 调料摩卡
 * @date 2024/02/26 22:03:24
 */
public class Mocha extends CondimentDecorator {

  public Mocha(Beverage beverage) {
    super(beverage);
    description = "摩卡";
  }

  public Mocha(Beverage beverage, SizeEnum sizeEnum){
    super(beverage);
    description = "摩卡";
    this.sizeEnum = sizeEnum;
  }

  @Override
  public double cost() {
    double price = 0.00;
    if (sizeEnum == SizeEnum.SMALL){
      price = 0.15;
    } else if (sizeEnum == SizeEnum.Middle){
      price = 0.35;
    } else if (sizeEnum == SizeEnum.BIG){
      price = 0.45;
    }else{
      throw new IllegalArgumentException("调料:摩卡 参数错误:" + sizeEnum.getSize());
    }
    return price + beverage.cost();
  }

  @Override
  public String getDescription() {
    return sizeEnum.getSize() + description + beverage.getDescription();
  }
}
