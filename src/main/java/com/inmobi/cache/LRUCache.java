package com.inmobi.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by siva on 08/10/17.
 */
public class LRUCache<K, V> {

  private LinkedHashMap<K, V> cache = null;
  private int capacity = 0;

  /**
   * We will be setting max capacity of LRU Cache.
   *
   * @param capacity
   */
  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new LinkedHashMap<K, V>(capacity);
  }

  /**
   * Get the value of the key if the key exists in the cache, otherwise returns NULL
   * If the key already exists in the map then removes and add it at the end of map.
   * Synchronized is used for access only one thread at a time.
   *
   * @param key
   * @return
   */
  public synchronized V get(K key) {
    if (cache.get(key) != null) {
      V value = cache.get(key);
      cache.remove(key);
      cache.put(key, value);
      return value;
    }
    return null;
  }

  /**
   * Put the value if the key is not already present.
   * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item
   * If the key already exists in the map then removes and add it at the end of map with new value.
   *
   * @param key
   * @param value
   */
  public synchronized void put(K key, V value) {
    V existingValue = get(key);
    if (existingValue != null) {
      cache.remove(key);
      cache.put(key, value);
    } else if (cache.size() < capacity) {
      cache.put(key, value);
    } else {
      Iterator<K> itr = cache.keySet().iterator();
      cache.remove(itr.next());
      cache.put(key, value);
    }
  }

  public static void main(String[] args) {
    LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(5);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    cache.put(5, 5);
    cache.put(6, 6);
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));

  }
}


