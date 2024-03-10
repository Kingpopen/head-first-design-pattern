package com.kingpopen.iteratorpattern.impl;

import com.kingpopen.iteratorpattern.Iterator;
import com.kingpopen.iteratorpattern.MenuItem;
import lombok.AllArgsConstructor;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description
 * @date 2024/3/10 21:19:01
 */
public class DinerMenuIterator implements Iterator {

  private final MenuItem[] items;
  private int position = 0;

  public DinerMenuIterator(MenuItem[] items) {
    this.items = items;
  }

  @Override
  public boolean hasNext() {
    return position < items.length && items[position] != null;
  }

  @Override
  public Object next() {
    if (position < items.length) {
      return items[position++];
    }
    return null;
  }
}
