package com.kingpopen.decoratorpattern.jdk;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 自定义的 读取流 将字母改成小写
 * @date 2024/02/27 22:15:25
 */
public class LowerCaseInputStream extends FilterInputStream {

  /**
   * Creates a <code>FilterInputStream</code> by assigning the  argument <code>in</code> to the field
   * <code>this.in</code> so as to remember it for later use.
   *
   * @param in the underlying input stream, or <code>null</code> if this instance is to be created
   *           without an underlying stream.
   */
  protected LowerCaseInputStream(InputStream in) {
    super(in);
  }

  // 重写read 方法
  @Override
  public int read() throws IOException {
    int read = super.read();
    return read == -1 ? read : Character.toLowerCase((char)read);
  }

  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    int result = super.read(b, off, len);
    for (int i = off; i < off + result; i ++){
      b[i] = (byte) Character.toLowerCase((char) b[i]);
    }
    return result;
  }
}
