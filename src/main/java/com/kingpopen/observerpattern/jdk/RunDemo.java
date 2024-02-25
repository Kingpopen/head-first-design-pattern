package com.kingpopen.observerpattern.jdk;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/2/25 20:37:42
 */
public class RunDemo {

  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();

    CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

    weatherData.setTemperature(1.0);
    weatherData.setHumidity(2.0);
    weatherData.setPressure(3.0);
    weatherData.measurementsChanged();
  }
}
