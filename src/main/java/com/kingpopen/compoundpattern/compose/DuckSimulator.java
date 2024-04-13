package com.kingpopen.compoundpattern.compose;

import com.kingpopen.compoundpattern.Quackable;
import com.kingpopen.compoundpattern.decorator.QuackCountDecorator;
import com.kingpopen.compoundpattern.factory.DecoratorDuckFactory;
import com.kingpopen.compoundpattern.factory.DuckFactory;
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

    // 将鸭子放进集群 构建集群鸭
    DuckFlock flock = new DuckFlock();
    flock.add(mallardDuck);
    flock.add(redDuck);
    flock.add(adapterDuck);
    flock.add(mallardDecoratorDuck);
    flock.add(redDecoratorDuck);
    flock.add(adapterDecoratorDuck);

    simulate(flock);

    log.info("装饰器鸭子叫了{}声!", QuackCountDecorator.getCount());
  }

  private static void simulate(Quackable duck) {
    duck.quack();
  }
}
