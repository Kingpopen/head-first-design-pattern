package com.kingpopen.facadepattern.impl;

import com.kingpopen.facadepattern.Facade;
import com.kingpopen.facadepattern.Food;
import com.kingpopen.facadepattern.TV;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 外观的实现类
 * @date 2024/3/9 21:31:34
 */
@Slf4j
@AllArgsConstructor
public class FacadeImpl implements Facade {
  private TV tv;
  private Food food;
  @Override
  public void watchMovie() {
    log.info("准备观看电影");
    food.buy();
    food.eat();
    tv.on();
  }

  @Override
  public void endMovie() {
    log.info("结束观看电影");
    food.end();
    tv.off();
  }
}
