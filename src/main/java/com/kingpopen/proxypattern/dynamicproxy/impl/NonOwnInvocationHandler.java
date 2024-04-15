package com.kingpopen.proxypattern.dynamicproxy.impl;

import com.kingpopen.proxypattern.dynamicproxy.Person;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 不是自身的处理类
 * @date 2024/03/20 23:07:03
 */
@Slf4j
@AllArgsConstructor
public class NonOwnInvocationHandler implements InvocationHandler {
  // 真实的对象
  private Person person;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (method.getName().equals("setRating")) {
      return method.invoke(person, args);
    } else {
      log.warn("不是自身不能调用{}方法", method.getName());
      throw new IllegalAccessException(String.format("不是自身不能调用%s方法", method.getName()));
    }
  }
}
