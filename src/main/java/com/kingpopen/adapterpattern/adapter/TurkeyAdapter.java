package com.kingpopen.adapterpattern.adapter;

import com.kingpopen.adapterpattern.adaptee.Turkey;
import com.kingpopen.adapterpattern.target.Duck;
import lombok.AllArgsConstructor;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 适配器类
 * @date 2024/3/9 19:34:59
 */
@AllArgsConstructor
public class TurkeyAdapter implements Duck {
  // 被适配者的引用
  private final Turkey turkey;

  @Override
  public void quack() {
    // 调用被适配者的方法
    turkey.gobble();
  }
}
