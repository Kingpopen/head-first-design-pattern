package com.kingpopen.observerpattern.impl;

import com.kingpopen.observerpattern.Display;
import com.kingpopen.observerpattern.Observer;
import com.kingpopen.observerpattern.Subject;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 预测板
 * @date 2024/02/21 22:01:03
 */
@Slf4j
public class ForecastDisplay implements Observer, Display {
  private Subject subject;

  public ForecastDisplay(Subject subject){
    this.subject = subject;
    this.subject.add(this);
  }

  @Override
  public void update(double temperature, double humidity, double pressure) {
    display();
  }

  @Override
  public void display() {
    log.info("天气预报！");
  }
}
