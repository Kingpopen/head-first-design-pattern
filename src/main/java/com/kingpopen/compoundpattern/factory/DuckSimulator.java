package com.kingpopen.compoundpattern.factory;

import com.kingpopen.compoundpattern.MallardDuck;
import com.kingpopen.compoundpattern.Quackable;
import com.kingpopen.compoundpattern.RedHeadDuck;
import com.kingpopen.compoundpattern.adapter.Goose;
import com.kingpopen.compoundpattern.adapter.GooseAdapter;
import com.kingpopen.compoundpattern.decorator.QuackCountDecorator;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 鸭子模拟器
 * @date 2024/4/13 19:42:03
 */
@Slf4j
public class DuckSimulator {

  public static void main(String[] args) {
    // 工厂模式创建鸭子
    DuckFactory duckFactory = new DuckFactory();
    Quackable mallardDuck = duckFactory.createMallardDuck();
    Quackable redDuck = duckFactory.createRedDuck();
    Quackable adapterDuck = duckFactory.createAdapterDuck();

    DecoratorDuckFactory decoratorDuckFactory = new DecoratorDuckFactory();
    Quackable mallardDecoratorDuck = decoratorDuckFactory.createMallardDuck();
    Quackable redDecoratorDuck = decoratorDuckFactory.createRedDuck();
    Quackable adapterDecoratorDuck = decoratorDuckFactory.createAdapterDuck();

    simulate(mallardDuck);
    simulate(redDuck);
    simulate(adapterDuck);

    simulate(mallardDecoratorDuck);
    simulate(redDecoratorDuck);
    simulate(adapterDecoratorDuck);

    log.info("装饰器鸭子叫了{}声!", QuackCountDecorator.getCount());
  }

  private static void simulate(Quackable duck) {
    duck.quack();
  }
}
