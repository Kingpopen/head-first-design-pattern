package com.kingpopen.compoundpattern.subjectandobserver.observer;

import com.kingpopen.compoundpattern.subjectandobserver.subject.Observable;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 观察者接口
 * @date 2024/4/13 23:00:03
 */
public interface Observer {

  // 当观察者被通知时调用的方法
  void update(Observable observable);
}
