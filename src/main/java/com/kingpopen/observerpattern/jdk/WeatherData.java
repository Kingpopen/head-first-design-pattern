package com.kingpopen.observerpattern.jdk;

import java.util.Observable;
import lombok.Data;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 天气数据类
 * @date 2024/2/25 20:16:46
 */
@Data
public class WeatherData extends Observable {
  // 温度
  private double temperature;
  // 湿度
  private double humidity;
  // 压强
  private double pressure;

  public void measurementsChanged(){
    setChanged();
    notifyObservers();
  }


}
