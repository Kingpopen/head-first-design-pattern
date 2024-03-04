package com.kingpopen.singletonpattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 运行类
 * @date 2024/03/04 21:36:06
 */
public class RunDemo {

  //线程池
  private final static ExecutorService executorService = Executors.newFixedThreadPool(10);
  private static final AtomicInteger cnt = new AtomicInteger(0);

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++){
      executorService.execute(RunDemo::demo);
      System.out.println(cnt.incrementAndGet());
    }
    executorService.shutdown();
  }

  private static void demo(){
    // 获取单实例
    Singleton.getSingletonInstance();
  }
}
