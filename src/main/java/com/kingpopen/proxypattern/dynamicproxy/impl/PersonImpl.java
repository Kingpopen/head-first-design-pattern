package com.kingpopen.proxypattern.dynamicproxy.impl;

import com.kingpopen.proxypattern.dynamicproxy.Person;
import lombok.Data;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 人的实现类
 * @date 2024/03/20 22:59:35
 */
@Data
public class PersonImpl implements Person {
  private String name;
  private String interest;
  private Integer rating;

  public PersonImpl(String name, String interest) {
    this.name = name;
    this.interest = interest;
    this.rating = 0;
  }

  public void setRating(Integer rating) {
    this.rating += rating;
  }
}
