package com.kingpopen.decoratorPattern.normal.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 饮料的尺寸
 * @date 2024/02/26 22:17:39
 */
@Getter
@AllArgsConstructor
public enum SizeEnum {

  SMALL("小杯"),
  Middle("中杯"),
  BIG("大杯");

  private String size;
}
