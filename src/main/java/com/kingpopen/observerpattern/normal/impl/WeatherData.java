package com.kingpopen.observerpattern.normal.impl;

import com.kingpopen.observerpattern.normal.Observer;
import com.kingpopen.observerpattern.normal.Subject;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 天气数据类
 * @date 2024/02/21 22:02:17
 */
@Slf4j
public class WeatherData implements Subject {
  private double temperature;
  private double humidity;
  private double pressure;

  // 存放观察者的数据结构
  private final List<Observer> observerList = new ArrayList<>();

  @Override
  public void add(Observer observer) {
    for (Observer item : observerList) {
      if (item == observer){
        log.warn("已经存在该观察者了! 观察者:{}",  observer);
        throw new RuntimeException("已经存在该观察者了!");
      }
    }
    observerList.add(observer);
  }

  @Override
  public void remove(Observer observer) {
    observerList.remove(observer);
  }

  @Override
  public void notifyObservers() {
    observerList.forEach(observer -> observer.update(temperature, humidity, pressure));
  }

  // 发生改变
  public void measurementsChanged(){
    notifyObservers();
  }

  public void setMeasurements(double temperature, double humidity, double pressure){
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }
}
