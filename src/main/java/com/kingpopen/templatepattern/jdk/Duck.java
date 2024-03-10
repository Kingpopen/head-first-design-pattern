package com.kingpopen.templatepattern.jdk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 鸭子
 * @date 2024/3/10 20:14:04
 */
@Slf4j
@Getter
@AllArgsConstructor
public class Duck implements Comparable {

  private String name;
  private int weight;


  @Override
  public int compareTo(Object o) {
    Duck otherDuck = (Duck) o;
    if (this.weight < otherDuck.getWeight()) {
      return -1;
    } else if (this.weight == otherDuck.getWeight()) {
      return 0;
    } else {
      return 1;
    }
  }

  @Override
  public String toString() {
    return "Duck{" +
        "name='" + name + '\'' +
        ", weight=" + weight +
        '}';
  }
}
