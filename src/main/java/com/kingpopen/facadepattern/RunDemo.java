package com.kingpopen.facadepattern;

import com.kingpopen.facadepattern.impl.FacadeImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/3/9 21:27:05
 */
@Slf4j
public class RunDemo {

  public static void main(String[] args) {
    // 系统组件
    TV tv = new TV();
    Food food = new Food();

    // 外观接口
    Facade facade = new FacadeImpl(tv, food);

    // 调用外观接口
    facade.watchMovie();
    log.info("====================================");
    facade.endMovie();
  }
}
