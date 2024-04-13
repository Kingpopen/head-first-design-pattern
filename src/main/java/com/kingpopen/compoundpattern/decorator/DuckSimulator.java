package com.kingpopen.compoundpattern.decorator;

import com.kingpopen.compoundpattern.MallardDuck;
import com.kingpopen.compoundpattern.Quackable;
import com.kingpopen.compoundpattern.RedHeadDuck;
import com.kingpopen.compoundpattern.adapter.Goose;
import com.kingpopen.compoundpattern.adapter.GooseAdapter;
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
    // 装饰模式 （装饰器模式会 修改 方法：添加了计数的方式）
    QuackCountDecorator mallardDuck = new QuackCountDecorator(new MallardDuck());
    QuackCountDecorator redHeadDuck = new QuackCountDecorator(new RedHeadDuck());
    QuackCountDecorator adapterDuck = new QuackCountDecorator(
        new GooseAdapter(new Goose()));

    simulate(mallardDuck);
    simulate(redHeadDuck);
    simulate(adapterDuck);

    log.info("鸭子叫了{}声！", QuackCountDecorator.getCount());
  }

  private static void simulate(Quackable duck) {
    duck.quack();
  }
}
