package com.ds.cache;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SimpleCache implements Cache<Integer, Integer> {
	Map<Integer, Value> map;
	
	int capacity;
	Random r = new Random();
	
	public SimpleCache(int cap) {
		this.capacity = cap;
		this.map = new ConcurrentHashMap<>(cap);
	}
	
	@Override
	public synchronized Integer get(Integer key) {
		if (!map.containsKey(key)) {
				Value val = getValFromSrc(key);
				addToEnd(val);
				map.put(key, val);	
		} else {
			alter(map.get(key));
		}
		return map.get(key).getVal();
	}

	public abstract void addToEnd(Value val);
	public abstract void alter(Value val);
	
	/**
	 * Get value from source mocked. In reality this could fetch from any source
	 * @param key
	 * @return
	 */
	private Value getValFromSrc(Integer key) {
		return new Value(key, r.nextInt(1000));
	}
}
