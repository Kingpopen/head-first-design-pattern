package com.kingpopen.templatepattern.jdk;

import java.awt.Graphics;
import javax.swing.JFrame;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description
 * @date 2024/3/10 20:34:57
 */
@Getter
public class MyFrame extends JFrame {
  private String title;
  private String msg;

  public MyFrame(String title, String msg) {
    super(title);
    this.title = title;
    this.msg = msg;
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300, 300);
    this.setVisible(true);
  }

  // 钩子方法
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.drawString(msg, 100, 100);
  }
}
