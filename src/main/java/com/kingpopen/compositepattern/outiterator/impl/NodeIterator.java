package com.kingpopen.compositepattern.outiterator.impl;

import java.util.Iterator;
import java.util.Stack;
import lombok.AllArgsConstructor;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 节点的迭代器
 * @date 2024/3/15 13:02:06
 */
public class NodeIterator implements Iterator {
  private Stack<Iterator> stack = new Stack<>();

  public NodeIterator(Iterator iterator){
    stack.push(iterator);
  }

  @Override
  public boolean hasNext() {
    if (stack.isEmpty()){
      return false;
    }

    return false;
  }

  @Override
  public Object next() {
    return null;
  }
}
