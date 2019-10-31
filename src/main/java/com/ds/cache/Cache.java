package com.ds.cache;

import java.util.Set;

public interface Cache<K,V> {
	public V get(K k);
	public Set<K> keys();
}
