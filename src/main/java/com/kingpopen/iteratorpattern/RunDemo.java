package com.kingpopen.iteratorpattern;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/3/10 21:09:56
 */
public class RunDemo {

  public static void main(String[] args) {
    // 菜单
    PanCakeHouseMenu panCakeHouseMenu = new PanCakeHouseMenu();
    DinerMenu dinerMenu = new DinerMenu();
    // 服务员
    Waitress waitress = new Waitress();
    waitress.addMenu(panCakeHouseMenu);
    waitress.addMenu(dinerMenu);
    waitress.printMenu();
  }
}
