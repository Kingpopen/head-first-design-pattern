package com.kingpopen.observerpattern.jdk;

import java.util.Observable;
import java.util.Observer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 预告天气
 * @date 2024/2/25 20:33:30
 */
@Slf4j
public class ForecastDisplay implements Observer, Display {
  private Observable observable;

  public ForecastDisplay(Observable observable){
    this.observable = observable;
    this.observable.addObserver(this);
  }

  @Override
  public void display() {
    log.info("天气预告!");
  }

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof WeatherData){
      WeatherData weatherData = (WeatherData) o;
      display();
      log.info("温度: {} 湿度:{} 压强:{}", weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
    }
  }
}
