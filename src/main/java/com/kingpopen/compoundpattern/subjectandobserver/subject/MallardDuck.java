package com.kingpopen.compoundpattern.subjectandobserver.subject;

import com.kingpopen.compoundpattern.subjectandobserver.observer.Observer;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 绿头鸭
 * @date 2024/4/13 23:15:04
 */
public class MallardDuck implements Quackable {

  // 通过ObservableHelper 辅助进行通知观察者（重用了部分代码）
  private ObservableHelper observableHelper = new ObservableHelper(this);

  @Override
  public void registerObserver(Observer observer) {
    observableHelper.registerObserver(observer);
  }

  @Override
  public void notifyObservers() {
    observableHelper.notifyObservers();
  }

  @Override
  public void quack() {
    notifyObservers();
  }
}
