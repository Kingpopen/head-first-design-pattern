package com.kingpopen.compoundpattern.subjectandobserver.observer;

import com.kingpopen.compoundpattern.subjectandobserver.subject.Observable;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 专家  把注册的功能放到了外界  有的时候时放在观察者里注册
 * @date 2024/4/13 23:21:10
 */
@Slf4j
public class QuackLogist implements Observer{

  @Override
  public void update(Observable observable) {
    log.info("logist is be notify " + observable);
  }
}
