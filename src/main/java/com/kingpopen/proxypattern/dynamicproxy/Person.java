package com.kingpopen.proxypattern.dynamicproxy;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 人 接口
 * @date 2024/03/20 22:57:28
 */
public interface Person {
  String getName();

  String getInterest();

  Integer getRating();

  void setName(String name);

  void setInterest(String interest);

  void setRating(Integer rating);
}
