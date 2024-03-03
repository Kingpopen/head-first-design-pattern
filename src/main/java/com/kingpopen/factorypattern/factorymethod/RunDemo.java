package com.kingpopen.factorypattern.factorymethod;

import com.kingpopen.factorypattern.factorymethod.storeimpl.ChicagoPizzaStore;
import com.kingpopen.factorypattern.factorymethod.storeimpl.NYPizzaStore;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/3/3 14:38:43
 */
public class RunDemo {

  public static void main(String[] args) {
    chicagoDemo();
  }

  public static void nyDemo(){
    // 1.创建商店
    AbstractPizzaStore pizzaStore = new NYPizzaStore();
    // 2. 点单
    pizzaStore.orderPizza("Cheese");
  }

  public static void chicagoDemo(){
    // 1.创建商店
    AbstractPizzaStore pizzaStore = new ChicagoPizzaStore();
    // 2. 点单
    pizzaStore.orderPizza("greek");
  }




}
