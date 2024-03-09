package com.kingpopen.adapterpattern.adaptee;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 火鸡类
 * @date 2024/3/9 19:35:49
 */
@Slf4j
public class Turkey {
  // 火鸡的叫声
  public void gobble() {
    log.info("咕咕咕!");
  }
}
