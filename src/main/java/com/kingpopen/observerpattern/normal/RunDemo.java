package com.kingpopen.observerpattern.normal;

import com.kingpopen.observerpattern.normal.impl.CurrentConditionsDisplay;
import com.kingpopen.observerpattern.normal.impl.ForecastDisplay;
import com.kingpopen.observerpattern.normal.impl.StatisticsDisplay;
import com.kingpopen.observerpattern.normal.impl.WeatherData;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/02/21 22:25:19
 */
public class RunDemo {

  public static void main(String[] args) {
    // 主题
    WeatherData weatherData = new WeatherData();

    // 观察者
    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
    
    //发生变化
    weatherData.setMeasurements(1, 2, 3);
  }
}
