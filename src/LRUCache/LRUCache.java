package LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K, V> {
	
	int capacity;
	
	
	public LRUCache(int capacity, float loadFactor) {
		super(capacity,loadFactor,true);
		this.capacity = capacity;
	}
	
	@Override
	public V put(K k, V v) {
		return super.put(k,v);
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
		return super.size()> this.capacity;
	}

}
