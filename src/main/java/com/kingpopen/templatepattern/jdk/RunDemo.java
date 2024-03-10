package com.kingpopen.templatepattern.jdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import javax.swing.JFrame;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description 运行类
 * @date 2024/3/10 20:13:42
 */
@Slf4j
public class RunDemo {

  public static void main(String[] args) {
//    duckDemo();
    jFrameDemo();
  }

  private static void duckDemo(){
    Duck donaldDuck = new Duck("唐纳德鸭", 10);
    Duck daisyDuck = new Duck("黛西鸭", 8);
    Duck hueyDuck = new Duck("休伊鸭", 12);
    Duck[] ducks = {donaldDuck, daisyDuck, hueyDuck};
    Arrays.sort(ducks);
    Arrays.stream(ducks).forEach(System.out::println);
  }

  private static void jFrameDemo(){
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      System.out.println("请输入要显示的消息：" );
      String msg = in.readLine();
      new MyFrame("Head First Design Patterns", msg);
    } catch (IOException e) {
      log.info("读取控制台输入发生异常！", e);
      throw new RuntimeException("读取控制台输入发生异常！");
    }
  }
}
