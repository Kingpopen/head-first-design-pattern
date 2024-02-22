package com.kingpopen.observerpattern.impl;

import com.kingpopen.observerpattern.Display;
import com.kingpopen.observerpattern.Observer;
import com.kingpopen.observerpattern.Subject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 统计信息
 * @date 2024/02/21 21:58:55
 */
@Slf4j
public class StatisticsDisplay implements Observer, Display {

  private Subject subject;

  public StatisticsDisplay(Subject subject){
    this.subject = subject;
    this.subject.add(this);
  }

  @Override
  public void update(double temperature, double humidity, double pressure) {
    display();
  }

  @Override
  public void display() {
    log.info("当前的最小 平均 最大值");
  }
}
