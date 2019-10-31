package com.ds.cache.local;

import com.ds.cache.list.DoublyLinkedList;
import com.ds.cache.list.Value;

public class LocalLRUCache extends LocalCache {
	DoublyLinkedList list;
	public LocalLRUCache(int cap) {
		super(cap);
		list = new DoublyLinkedList();
	}

	/**
	 * For LRU cache adds to end of list
	 */
	@Override
	public synchronized void addToList(Value val) {
		if (map.size() == capacity) {
			Value oldVal = list.poll();
			System.out.println("Maxx cap - evict"+oldVal.getKey());			
			map.remove(oldVal.getKey());
		}
		list.pour(val);
	}

	/**
	 * For LRU cache move from current post to end of list
	 */
	@Override
	public synchronized void alterPositionInList(Value val) {
		System.out.println("Revisiting: "+val.getKey());
		list.moveToEnd(val);
	}
	
	/**
	 * Prints the current cache keys
	 */
	@Override
	public synchronized void printCacheKeys() {		
		System.out.print(this+"->");
		list.printList();
		System.out.println();
	}
}
