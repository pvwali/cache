package com.cache;

import java.util.Set;

public interface ICache<K,V> {
	public V get(K k);
	public Set<K> keys();
}
