package com.kingpopen.observerpattern.normal.impl;

import com.kingpopen.observerpattern.normal.Display;
import com.kingpopen.observerpattern.normal.Observer;
import com.kingpopen.observerpattern.normal.Subject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 当前状态
 * @date 2024/02/21 21:56:43
 */
@Slf4j
public class CurrentConditionsDisplay implements Observer, Display {
  // 观察者里面 还存放了一个指向主题的引用
  private Subject subject;

  public CurrentConditionsDisplay(Subject subject){
    this.subject = subject;
    this.subject.add(this);
  }

  // update 是指给 主题调用，真正执行的操作还是display
  @Override
  public void update(double temperature, double humidity, double pressure) {
    display();
  }

  @Override
  public void display() {
    log.info("当前状态");
  }
}
