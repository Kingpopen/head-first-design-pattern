package com.kingpopen.iteratorpattern;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 迭代器接口
 * @date 2024/3/10 21:16:33
 */
public interface Iterator {
  // 是否还有下一个
  boolean hasNext();
  // 下一个元素
  Object next();
}
