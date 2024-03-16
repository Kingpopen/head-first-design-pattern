package com.kingpopen.compositepattern.inneriterator;

import lombok.AllArgsConstructor;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 服务员
 * @date 2024/3/15 12:53:25
 */
@AllArgsConstructor
public class Waitress {
  // 根节点
  private Node root;

  public void print(){
    this.root.print();
  }
}
