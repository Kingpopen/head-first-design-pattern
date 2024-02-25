package com.kingpopen.observerpattern.jdk;

import java.util.Observable;
import java.util.Observer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 当前天气
 * @date 2024/2/25 20:24:44
 */
@Slf4j
public class CurrentConditionDisplay implements Observer, Display{
  private Observable observable;

  public CurrentConditionDisplay(Observable observable){
    this.observable = observable;
    this.observable.addObserver(this);
  }

  @Override
  public void display() {
    log.info("展示当前天气!");
  }

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof WeatherData){
      WeatherData data = (WeatherData) o;
      display();
      log.info("温度:{} 湿度:{} 压强:{}", data.getTemperature(), data.getHumidity(), data.getPressure());
    }
  }
}
