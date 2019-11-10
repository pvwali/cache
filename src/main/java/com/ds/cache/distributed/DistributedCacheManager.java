package com.ds.cache.distributed;

import java.util.ArrayList;
import java.util.List;

import com.cache.ICache;
import com.ds.cache.local.LocalLRUCache;

public class DistributedCacheManager {
	int clusters = 5;
	List<ICache<Integer, Integer>> localCaches;
	
	private static DistributedCacheManager _instance;
	public static DistributedCacheManager getInstance() {
		if (_instance == null) {
			_instance = new DistributedCacheManager();
		}
		return _instance;
	}
	
	private DistributedCacheManager() {
		localCaches = new ArrayList<ICache<Integer,Integer>>(clusters);
		init();
	}

	private void init() {
		for (int i=0; i<clusters; i++) {
			localCaches.add(new LocalLRUCache(10));
		}
	}
	
	ICache<Integer, Integer> getCacheInstance(int n) {
		if (n >= localCaches.size()) {
			return null;
		}
		return localCaches.get(n);
	}
}
