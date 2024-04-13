package com.kingpopen.compoundpattern.subjectandobserver.subject;

import com.kingpopen.compoundpattern.subjectandobserver.subject.Observable;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 可观察的 鸭子叫接口, 继承了Observable 接口，说明含有了可被观察的能力
 * @date 2024/4/13 23:05:44
 */
public interface Quackable extends Observable {
  void quack();
}
