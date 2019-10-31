package com.ds.cache.local;

import java.util.PriorityQueue;

import com.ds.cache.list.Value;

public class LocalLFUCache extends LocalCache {
	PriorityQueue<Value> list;
	public LocalLFUCache(int cap) {
		super(cap);
		list = new PriorityQueue<Value>((a,b)->a.getFreq()-b.getFreq());
	}

	/**
	 * For LRU cache adds to end of list
	 */
	@Override
	public synchronized void addToList(Value val) {
		if (map.size() == capacity) {
			Value oldVal = list.poll();
			System.out.println("Maxx cap - evict "+oldVal.getKey());			
			map.remove(oldVal.getKey());
		}
		list.offer(val);
	}

	/**
	 * For LRU cache move from current post to end of list
	 */
	@Override
	public synchronized void alterPositionInList(Value val) {
		System.out.println("Revisiting: "+val.getKey());
		list.remove(val);
		val.incrFreq();
		list.offer(val);
	}
	
	/**
	 * Prints the current cache keys
	 */
	@Override
	public void printCacheKeys() {
		Value v = list.peek();
		System.out.println(v.getKey()+":"+v.getFreq());		
	}
}