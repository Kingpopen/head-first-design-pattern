package com.kingpopen.observerpattern;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 观察者接口
 * @date 2024/02/21 21:55:02
 */
public interface Observer {
  void update(double temperature, double humidity, double pressure);
}
