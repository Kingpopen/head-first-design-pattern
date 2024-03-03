package com.kingpopen.factorypattern.simplefactory;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 披萨接口
 * @date 2024/3/3 13:56:06
 */
public interface Pizza {
  // 准备
  void prepare();
  // 烘培
  void bake();
  // 切
  void cut();
  // 装盒
  void box();
}
