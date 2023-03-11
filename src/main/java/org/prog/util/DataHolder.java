package org.prog.util;

import java.util.HashMap;

public class DataHolder {

  private final static DataHolder instance = new DataHolder();

  private final HashMap<String, Object> holder;

  private DataHolder() {
    holder = new HashMap<>();
  }

  public static DataHolder getInstance() {
    return instance;
  }

  public void put(String key, Object value) {
    holder.put(key, value);
  }

  public Object get(String key) {
    if (!holder.containsKey(key)) {
      throw new RuntimeException("Key not found Exception");
    }
    return holder.get(key);
  }
}
