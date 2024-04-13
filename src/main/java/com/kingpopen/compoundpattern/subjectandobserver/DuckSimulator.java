package com.kingpopen.compoundpattern.subjectandobserver;

import com.kingpopen.compoundpattern.subjectandobserver.observer.QuackLogist;
import com.kingpopen.compoundpattern.subjectandobserver.subject.MallardDuck;
import com.kingpopen.compoundpattern.subjectandobserver.subject.Quackable;
import com.kingpopen.compoundpattern.subjectandobserver.subject.RedHeadDuck;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 模拟器
 * @date 2024/4/13 23:25:01
 */
public class DuckSimulator {

  public static void main(String[] args) {
    // 观察者
    QuackLogist quackLogist = new QuackLogist();

    // 主题
    MallardDuck mallardDuck = new MallardDuck();
    RedHeadDuck redHeadDuck = new RedHeadDuck();

    // 注册
    mallardDuck.registerObserver(quackLogist);
    redHeadDuck.registerObserver(quackLogist);

    // 执行
    simulate(mallardDuck);
    simulate(redHeadDuck);
  }

  public static void simulate(Quackable duck){
    duck.quack();
  }
}
