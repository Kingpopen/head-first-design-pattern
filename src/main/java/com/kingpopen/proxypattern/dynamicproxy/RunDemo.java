package com.kingpopen.proxypattern.dynamicproxy;

import com.kingpopen.proxypattern.dynamicproxy.impl.NonOwnInvocationHandler;
import com.kingpopen.proxypattern.dynamicproxy.impl.OwnInvocationHandler;
import com.kingpopen.proxypattern.dynamicproxy.impl.PersonImpl;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 运行类
 * @date 2024/03/20 23:11:11
 */
@Slf4j
public class RunDemo {

  public static void main(String[] args) {
    Person zhangSan = new PersonImpl("张三", "学习");

    Person zhangSanOwnerProxy = getOwnerProxy(zhangSan);
    zhangSanOwnerProxy.setInterest("唱跳 rapper 和 篮球");
    try {
      zhangSanOwnerProxy.setRating(10);
    } catch (Exception e) {
      log.warn("不能给自己评分");
    }

    Person zhangSanNonOwnerProxy = getNonOwnerProxy(zhangSan);
    zhangSanNonOwnerProxy.setRating(10);

    try {
      zhangSanNonOwnerProxy.setInterest("打游戏");
    } catch (Exception e) {
      log.warn("不能给别人设置兴趣");
    }

  }

  private static Person getOwnerProxy(Person person) {
    return (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),
        person.getClass().getInterfaces(),
        new OwnInvocationHandler(person));
  }

  private static Person getNonOwnerProxy(Person person) {
    return (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),
        person.getClass().getInterfaces(),
        new NonOwnInvocationHandler(person));
  }
}
