package com.kingpopen.compositepattern.inneriterator;

import com.kingpopen.compositepattern.inneriterator.impl.LeafNode;
import com.kingpopen.compositepattern.inneriterator.impl.NormalNode;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/3/13 12:40:34
 */
public class RunDemo {

  public static void main(String[] args) {
    demo();
  }

  private static void demo(){
    Node foods = new NormalNode("早餐");
    Node noodles = new LeafNode("面条");
    Node mantou = new LeafNode("馒头");

    Node drinks = new NormalNode("饮品");
    Node coffee = new LeafNode("咖啡");
    Node milk = new LeafNode("牛奶");
    Node tea = new LeafNode("茶");
    drinks.add(coffee);
    drinks.add(milk);
    drinks.add(tea);

    foods.add(noodles);
    foods.add(mantou);
    foods.add(drinks);

    Waitress waitress = new Waitress(foods);
    waitress.print();
  }
}
