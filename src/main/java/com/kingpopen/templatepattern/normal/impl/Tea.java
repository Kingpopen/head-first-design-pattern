package com.kingpopen.templatepattern.normal.impl;

import com.kingpopen.templatepattern.normal.AbstractBeverage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 茶
 * @date 2024/3/10 00:13:16
 */
@Slf4j
@AllArgsConstructor
public class Tea extends AbstractBeverage {

  private BufferedReader in;

  @Override
  protected void brew() {
    log.info("Steeping the tea");
  }

  @Override
  public void addCondiments() {
    log.info("Adding Lemon");
  }

  // 对钩子方法进行覆盖
  @Override
  protected boolean isAddCondiments() {
    if (Objects.isNull(in)) {
      throw new RuntimeException("BufferedReader对象为空！");
    }
    System.out.println("是否加入柠檬调料？");
    try {
      String s = in.readLine();
      return s.toLowerCase().startsWith("y");
    } catch (IOException e) {
      log.error("Tea的添加调料方法发生异常！", e);
      throw new RuntimeException("Tea的添加调料方法发生异常！");
    }
  }
}
