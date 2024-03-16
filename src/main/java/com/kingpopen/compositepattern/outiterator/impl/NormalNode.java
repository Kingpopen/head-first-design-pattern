package com.kingpopen.compositepattern.outiterator.impl;

import com.kingpopen.compositepattern.inneriterator.Node;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 普通节点
 * @date 2024/3/13 12:52:19
 */
@Slf4j
public class NormalNode implements Node {
  // 采用集合进行节点的存储
  private List<Node> children;

  private String name;

  public NormalNode(String name){
    this.name = name;
    children = new ArrayList<>();
  }

  @Override
  public void add(Node node) {
    children.add(node);
  }

  @Override
  public void remove(Node node) {
    children.remove(node);
  }

  // 根 左 右
  @Override
  public void print() {
    log.info("========== {} ==========", name);
    children.forEach(Node::print);
  }
}
