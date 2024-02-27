package com.kingpopen.decoratorPattern.normal.baseimpl;

import com.kingpopen.decoratorPattern.normal.Beverage;
import com.kingpopen.decoratorPattern.normal.enums.SizeEnum;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 意式浓缩咖啡
 * @date 2024/02/26 21:59:26
 */
public class Espresso extends Beverage {

  public Espresso() {
    description = "意式浓缩咖啡";
  }

  public Espresso(SizeEnum sizeEnum) {
    description = "意式浓缩咖啡";
    this.sizeEnum = sizeEnum;
  }

  @Override
  public double cost() {
    if (sizeEnum == SizeEnum.SMALL) {
      return 0.3;
    } else if (sizeEnum == SizeEnum.Middle) {
      return 0.5;
    } else if (sizeEnum == SizeEnum.BIG) {
      return 0.8;
    } else {
      throw new IllegalArgumentException("意式浓缩咖啡 参数错误! 错误的参数是:" + sizeEnum.getSize());
    }
  }
}
