package com.csh.cache.node;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.cache.ICache;

public class Node implements ICache<Integer, Integer>{
	int id;
	int clusterKey;
	int capacity;
	
	Random r = new Random();
	Map<Integer, Integer> localCache;
	public Node(int id, int cap) {
		this.id = id;
		this.capacity = cap;
		localCache = new HashMap<>(cap);
	}
	
	/**
	 * Returns the value for the given key,
	 *  from the localCache
	 */
	@Override
	public Integer get(Integer k) {
		if (!localCache.containsKey(k)) {
			localCache.put(k, r.nextInt(100));
		}
		return localCache.get(k);
	}

	/**
	 * Returns the set of localCache keys
	 */
	@Override
	public Set<Integer> keys() {
		return localCache.keySet();
	}
	
	/** cluster key identifies the position of the node in the cluster **/
	public void setClusterKey(int key) {
		this.clusterKey = key;
	}
	public int getClusterKey() {
		return clusterKey;
	}
	
	public Integer getId() {
		return this.id;
	}
}
