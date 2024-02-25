package com.kingpopen.observerpattern.normal;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 主题
 * @date 2024/02/21 22:02:37
 */
public interface Subject {
  // 添加观察者
  void add(Observer observer);

  // 删除观察者
  void remove(Observer observer);

  // 通知
  void notifyObservers();
}
