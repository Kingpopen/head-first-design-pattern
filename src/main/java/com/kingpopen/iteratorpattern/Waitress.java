package com.kingpopen.iteratorpattern;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 服务员
 * @date 2024/3/10 21:27:22
 */
public class Waitress {
  private final List<Menu> menus = new ArrayList<>();

  public void addMenu(Menu menu){
    menus.add(menu);
  }

  public void printMenu() {
    menus.forEach(menu -> {
      Iterator iterator = menu.createIterator();
      System.out.println("=====" + menu.getClass().getSimpleName() + "=====");
      doPrintMenu(iterator);
    });
  }

  private void doPrintMenu(Iterator iterator) {
    while (iterator.hasNext()) {
      MenuItem menuItem = (MenuItem) iterator.next();
      System.out.print(menuItem.getName() + ", ");
      System.out.print(menuItem.getPrice() + " -- ");
      System.out.println(menuItem.getDescription());
    }
  }
}
