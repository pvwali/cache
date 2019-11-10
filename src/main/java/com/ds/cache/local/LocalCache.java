package com.ds.cache.local;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.cache.ICache;
import com.ds.cache.list.Value;

public abstract class LocalCache implements ICache<Integer, Integer> {
	Map<Integer, Value> map;
	
	String name;
	int capacity;
	Random r = new Random();
	
	public LocalCache(int cap) {
		this.name = "LC_"+r.nextInt(5000);
		this.capacity = cap;
		this.map = new ConcurrentHashMap<>(cap);
	}
	
	/**
	 * Servers the client with a simple get
	 */
	@Override
	public synchronized Integer get(Integer key) {
		if (!map.containsKey(key)) {
				Value val = getValFromSrc(key);
				addToList(val);
				map.put(key, val);	
		} else {
			alterPositionInList(map.get(key));
		}
		printCacheKeys();
		return map.get(key).getVal();
	}

	public abstract void addToList(Value val);
	public abstract void alterPositionInList(Value val);
	public abstract void printCacheKeys();
	
	/**
	 * Get value from source mocked. In reality this could fetch from any source
	 * @param key
	 * @return
	 */
	private Value getValFromSrc(Integer key) {
		return new Value(key, r.nextInt(1000));
	}
	
	/**
	 * Get the current cache keys
	 */
	@Override
	public Set<Integer> keys() {
		return map.keySet();
	}
	
	@Override
	public String toString() {
		return name;
	}
}
