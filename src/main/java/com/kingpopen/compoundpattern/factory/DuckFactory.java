package com.kingpopen.compoundpattern.factory;

import com.kingpopen.compoundpattern.MallardDuck;
import com.kingpopen.compoundpattern.Quackable;
import com.kingpopen.compoundpattern.RedHeadDuck;
import com.kingpopen.compoundpattern.adapter.Goose;
import com.kingpopen.compoundpattern.adapter.GooseAdapter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 鸭子工厂
 * @date 2024/4/13 22:13:20
 */
public class DuckFactory implements AbstractFactory{

  @Override
  public Quackable createMallardDuck() {
    return new MallardDuck();
  }

  @Override
  public Quackable createRedDuck() {
    return new RedHeadDuck();
  }

  @Override
  public Quackable createAdapterDuck() {
    return new GooseAdapter(new Goose());
  }
}
