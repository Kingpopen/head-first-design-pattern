package com.kingpopen.compoundpattern.subjectandobserver.subject;

import com.kingpopen.compoundpattern.subjectandobserver.observer.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 被观察者类（辅助类），封装了被观察者的一些操作
 * @date 2024/4/13 23:07:13
 */
public class ObservableHelper implements Observable {
  // 观察者列表
  private final List<Observer> observers = new ArrayList<>();
  // 被观察者
  private final Observable duck;

  public ObservableHelper(Observable duck){
    this.duck = duck;
  }


  // 注册观察者
  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  // 通知观察者
  @Override
  public void notifyObservers() {
    for (Observer observer : observers){
      observer.update(duck);
    }
  }
}
