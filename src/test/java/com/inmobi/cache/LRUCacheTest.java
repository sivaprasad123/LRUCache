package com.inmobi.cache;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by siva on 08/10/17.
 */
public class LRUCacheTest {

  private static LRUCache<Integer, Integer> cache = null;
  private final static int CAPACITY = 5;

  @BeforeClass
  public static void init() {
    cache = new LRUCache<Integer, Integer>(CAPACITY);
  }

  @Test
  public void test() {
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    cache.put(5, 5);
    cache.put(6, 6);
    //This will returns NULL. This was eldest one and this will be removed from LRUCache
    assertNull(cache.get(1));
    cache.get(2);
    cache.put(7, 7);
    //Since we used 2 recently. it will not be removed from cache
    assertNotNull(cache.get(2));

  }
}
