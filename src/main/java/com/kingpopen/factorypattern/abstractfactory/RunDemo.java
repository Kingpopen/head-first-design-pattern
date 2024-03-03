package com.kingpopen.factorypattern.abstractfactory;

import com.kingpopen.factorypattern.abstractfactory.pizza.Pizza;
import com.kingpopen.factorypattern.abstractfactory.store.impl.ChicagoPizzaStore;
import com.kingpopen.factorypattern.abstractfactory.store.impl.NyPizzaStore;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description
 * @date 2024/3/3 21:33:14
 */
public class RunDemo {

  public static void main(String[] args) {
    chicagoDemo();
  }

  private static void nyDemo(){
    NyPizzaStore store = new NyPizzaStore();
    Pizza cheese = store.orderPizza("cheese");
    System.out.println("披萨为:" + cheese.getName());
  }

  private static void chicagoDemo(){
    ChicagoPizzaStore store = new ChicagoPizzaStore();
    Pizza clam = store.orderPizza("clam");
    System.out.println("披萨为:" + clam.getName());
  }

}
