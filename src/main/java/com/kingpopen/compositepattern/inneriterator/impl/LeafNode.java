package com.kingpopen.compositepattern.inneriterator.impl;

import com.kingpopen.compositepattern.inneriterator.Node;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 叶子节点
 * @date 2024/3/13 12:55:11
 */
@Slf4j
public class LeafNode implements Node {
  private String name;

  public LeafNode(String name){
    this.name = name;
  }

  @Override
  public void add(Node node) {
    throw new UnsupportedOperationException("add 操作不支持!");
  }

  @Override
  public void remove(Node node) {
    throw new UnsupportedOperationException("remove 操作不支持");
  }

  @Override
  public void print() {
    log.info(name);
  }
}
