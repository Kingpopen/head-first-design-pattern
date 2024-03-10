package com.kingpopen.iteratorpattern;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 菜单项
 * @date 2024/3/10 21:11:05
 */
@Getter
@AllArgsConstructor
public class MenuItem {
  private String name;
  private String description;
  private boolean vegetarian;
  private double price;
}
