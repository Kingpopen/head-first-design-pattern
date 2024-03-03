package com.kingpopen.decoratorpattern.normal.decoratorimpl;

import com.kingpopen.decoratorpattern.normal.Beverage;
import com.kingpopen.decoratorpattern.normal.CondimentDecorator;
import com.kingpopen.decoratorpattern.normal.enums.SizeEnum;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 调料：奶油
 * @date 2024/02/26 22:08:21
 */
public class Whip extends CondimentDecorator {

  public Whip(Beverage beverage) {
    super(beverage);
    description = "奶油";
  }

  public Whip(Beverage beverage, SizeEnum sizeEnum){
    super(beverage);
    description = "奶油";
    this.sizeEnum = sizeEnum;
  }

  @Override
  public double cost() {
    double price = 0.00;
    if (sizeEnum == SizeEnum.SMALL){
      price = 0.50;
    } else if (sizeEnum == SizeEnum.Middle){
      price = 0.60;
    } else if (sizeEnum == SizeEnum.BIG){
      price = 0.70;
    }else{
      throw new IllegalArgumentException("调料:奶油 参数错误:" + sizeEnum.getSize());
    }
    return price + beverage.cost();
  }

  @Override
  public String getDescription() {
    return sizeEnum.getSize() + description + beverage.getDescription();
  }
}
