package com.kingpopen.commandpattern;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 命令类
 * @date 2024/03/06 22:06:47
 */
public interface Command {

  void execute();

  void undo();
}
