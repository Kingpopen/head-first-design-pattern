package com.kingpopen.compoundpattern.adapter;

import com.kingpopen.compoundpattern.Quackable;
import com.kingpopen.compoundpattern.adapter.Goose;
import lombok.AllArgsConstructor;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 鹅的适配器
 * @date 2024/4/13 19:46:20
 */
@AllArgsConstructor
public class GooseAdapter implements Quackable {
  private Goose goose;

  @Override
  public void quack() {
    goose.honk();
  }
}
