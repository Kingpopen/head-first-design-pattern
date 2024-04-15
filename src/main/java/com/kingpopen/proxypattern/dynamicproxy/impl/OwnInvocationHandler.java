package com.kingpopen.proxypattern.dynamicproxy.impl;

import com.kingpopen.proxypattern.dynamicproxy.Person;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 自身的处理类
 * @date 2024/03/20 23:02:48
 */
@Slf4j
@AllArgsConstructor
public class OwnInvocationHandler implements InvocationHandler {
  private Person person;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 自身不能调用评分方法
    if (method.getName().equals("setRating")) {
      log.warn("自身不能调用评分方法！");
      throw new IllegalAccessException("自身不能调用评分方法");
    } else {
      return method.invoke(person, args);
    }
  }
}
