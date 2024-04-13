package com.kingpopen.compoundpattern.subjectandobserver.subject;

import com.kingpopen.compoundpattern.subjectandobserver.observer.Observer;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 红头鸭
 * @date 2024/4/13 23:17:30
 */
public class RedHeadDuck implements Quackable {
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
