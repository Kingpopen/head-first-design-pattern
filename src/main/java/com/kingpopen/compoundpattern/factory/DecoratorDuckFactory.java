package com.kingpopen.compoundpattern.factory;

import com.kingpopen.compoundpattern.MallardDuck;
import com.kingpopen.compoundpattern.Quackable;
import com.kingpopen.compoundpattern.RedHeadDuck;
import com.kingpopen.compoundpattern.adapter.Goose;
import com.kingpopen.compoundpattern.adapter.GooseAdapter;
import com.kingpopen.compoundpattern.decorator.QuackCountDecorator;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 装饰器鸭子工厂
 * @date 2024/4/13 22:19:14
 */
public class DecoratorDuckFactory implements AbstractFactory{

  @Override
  public Quackable createMallardDuck() {
    return new QuackCountDecorator(new MallardDuck());
  }

  @Override
  public Quackable createRedDuck() {
    return new QuackCountDecorator(new RedHeadDuck());
  }

  @Override
  public Quackable createAdapterDuck() {
    return new QuackCountDecorator(new GooseAdapter(new Goose()));
  }
}
