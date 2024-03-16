package com.kingpopen.compositepattern.inneriterator;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 节点接口
 * @date 2024/3/13 12:51:07
 */
public interface Node {
  // 添加子节点
  void add(Node node);

  // 移除节点
  void remove(Node node);

  // 打印输出
  void print();
}
