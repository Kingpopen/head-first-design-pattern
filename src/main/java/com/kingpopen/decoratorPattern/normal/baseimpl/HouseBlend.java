package com.kingpopen.decoratorPattern.normal.baseimpl;

import com.kingpopen.decoratorPattern.normal.Beverage;
import com.kingpopen.decoratorPattern.normal.enums.SizeEnum;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 综合咖啡
 * @date 2024/02/26 22:01:47
 */
public class HouseBlend extends Beverage {

  public HouseBlend(){
    description = "综合咖啡";
  }

  public HouseBlend(SizeEnum sizeEnum){
    description = "综合咖啡";
    this.sizeEnum = sizeEnum;
  }

  @Override
  public double cost() {
    if (sizeEnum == SizeEnum.SMALL) {
      return 0.6;
    } else if (sizeEnum == SizeEnum.Middle) {
      return 0.8;
    } else if (sizeEnum == SizeEnum.BIG) {
      return 1.2;
    } else {
      throw new IllegalArgumentException("综合咖啡 参数错误! 错误的参数是:" + sizeEnum.getSize());
    }
  }
}
