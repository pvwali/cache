package com.ds.cache.distributed;

import java.util.Set;

import com.ds.cache.ICache;

public class DistributedCache implements IDistributedCache<Integer, Integer> {
	
	private DistributedCacheManager mgr;
	public DistributedCache() {
		this.mgr = DistributedCacheManager.getInstance();
	}
	
	@Override
	public Integer get(Integer k) {
		int n = k % mgr.localCaches.size();
		ICache<Integer, Integer> localCache = mgr.getCacheInstance(n);
		if (localCache == null) {
			return null;
		}
		return localCache.get(k);
	}

	@Override
	public Set<Integer> keys() {
		// TODO Auto-generated method stub
		return null;
	}
}
