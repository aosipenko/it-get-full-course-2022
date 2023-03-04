package org.prog.util;

import java.util.HashMap;
import org.junit.Assert;
import org.springframework.stereotype.Component;

@Component
public class DataHolder {

  private final HashMap<String, Object> holder = new HashMap<>();

  public void put(String key, Object value) {
    holder.put(key, value);
  }

  public Object get(String key) {
    if (!holder.containsKey(key)) {
      Assert.fail("Key not found " + key);
    }
    return holder.get(key);
  }
}
