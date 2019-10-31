package com.ds.cache.distributed;

import java.util.Set;

public class IDistributedCache {
	public V get(K k);
	public Set<K> keys();
}
