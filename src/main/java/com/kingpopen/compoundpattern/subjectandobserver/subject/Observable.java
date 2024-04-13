package com.kingpopen.compoundpattern.subjectandobserver.subject;

import com.kingpopen.compoundpattern.subjectandobserver.observer.Observer;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 被观察者（主题）接口
 * @date 2024/4/13 22:57:55
 */
public interface Observable{
  // 注册观察者
  void registerObserver(Observer observer);

  // 通知观察者
  void notifyObservers();
}
