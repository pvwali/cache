package com.ds.cache;

import com.ds.cache.list.DoublyLinkedList;
import com.ds.cache.list.Value;

public class SimpleLRUCache extends SimpleCache {
	DoublyLinkedList list;
	public SimpleLRUCache(int cap) {
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
			System.out.println("Maxx: "+oldVal.getKey());			
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
	public void printCacheKeys() {
		list.printList();
	}
}
