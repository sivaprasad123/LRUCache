# LRUCache

# Data structure: LinkedHashMap
    1. T get(K key): If the key exist in hashmap then it will remove key and will insert at the end of map.
    2. Void put (K key, V value): insert the key at the end of the map, If it doesn't exist. If it already exist then remove and insert at the end
If the size of the map matches the max capacity then removes the fist element from the hashmap and inserts at the end.

# Time complexity of the algorithm for put() and get() methods are O(1)

# Space complexity of the algorithm for put() and get() methods are O(n), Here n is max capacity of cache.
