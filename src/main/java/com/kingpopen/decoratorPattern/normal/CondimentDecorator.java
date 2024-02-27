package com.kingpopen.decoratorPattern.normal;

import lombok.AllArgsConstructor;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 调料装饰类
 * @date 2024/02/26 21:57:02
 */
@AllArgsConstructor
public abstract class CondimentDecorator extends Beverage{
  protected Beverage beverage;

  // 需要重写该方法
  public abstract String getDescription();
}
