package com.kingpopen.iteratorpattern.impl;

import com.kingpopen.iteratorpattern.Iterator;
import com.kingpopen.iteratorpattern.MenuItem;
import java.util.ArrayList;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 彭锦波
 * @project design-pattern
 * @description
 * @date 2024/3/10 21:21:48
 */
public class PanCakeHouseMenuIterator implements Iterator {
  private final ArrayList<MenuItem> items;
  private int position = 0;

  public PanCakeHouseMenuIterator(ArrayList<MenuItem> items) {
    this.items = items;
  }

  @Override
  public boolean hasNext() {
    return position < items.size() && Objects.nonNull(items.get(position));
  }

  @Override
  public Object next() {
    return items.get(position++);
  }

}
