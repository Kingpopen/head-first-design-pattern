package com.kingpopen.singletonpattern;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 单例
 * @date 2024/03/04 21:26:54
 */
@Slf4j
public class Singleton {
  // 单例的引用(volatile + 静态)
  private volatile static Singleton singletonInstance;

  // 私有的构造函数
  private Singleton(){
    // 在多线程获取单例的情况下， 只会被初始化一次
    log.info("Singleton的实例被创建!");
  }

  // 双重检查锁
  public static Singleton getSingletonInstance() {
    if (Objects.isNull(singletonInstance)){
      // 使用类对象作为锁 保证同步
      synchronized (Singleton.class){
        // 再一次判断
        if (Objects.isNull(singletonInstance)){
          singletonInstance = new Singleton();
        }
      }
    }
    // singletonInstance不为null 就不用抢占锁 减少性能开销
    return singletonInstance;
  }
}
