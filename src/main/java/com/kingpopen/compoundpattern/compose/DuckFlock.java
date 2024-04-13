package com.kingpopen.compoundpattern.compose;

import com.kingpopen.compoundpattern.Quackable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 鸭子集群
 * @date 2024/4/13 22:30:20
 */
public class DuckFlock implements Quackable {

  private List<Quackable> ducks = new ArrayList<>();

  public void add(final Quackable duck) {
    ducks.add(duck);
  }

  @Override
  public void quack() {
    for (Quackable duck : ducks) {
      duck.quack();
    }
  }
}
