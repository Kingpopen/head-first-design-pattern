package com.kingpopen.decoratorPattern.jdk;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 运行类
 * @date 2024/02/27 22:11:09
 */
@Slf4j
public class RunDemo {
  public static void main(String[] args) {
    int c;
    byte[] b = new byte[12];
    try (LowerCaseInputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("src/main/resources/decorator-file.txt")))){
      // 单个字符读取
      while((c = in.read()) != -1){
        System.out.print((char)c);
      }

      // 字符数组读取
//      int size = in.read(b, 0, 12);
//      for (int i = 0; i < size; i++ ) {
//        System.out.print((char) b[i]);
//      }
    } catch (FileNotFoundException e) {
      log.error("文件读取异常!", e);
      throw new RuntimeException("文件读取异常！", e);
    } catch (IOException e) {
      log.error("IO读取异常!", e);
      throw new RuntimeException("IO读取异常!", e);
    }
  }
}
