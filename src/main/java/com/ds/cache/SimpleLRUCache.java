package com.ds.cache;

public class SimpleLRUCache extends SimpleCache {
	Value head, tail;
	
	public SimpleLRUCache(int cap) {
		super(cap);
		head = null;
		tail = null;
	}

	@Override
	public synchronized void addToEnd(Value val) {
		if (map.size() == capacity) {
			Value oldVal = poll();
			System.out.println("Maxx: "+oldVal.key);			
			map.remove(oldVal.getKey());
		}
		pour(val);
		printList();		
	}

	@Override
	public synchronized void alter(Value val) {
		System.out.println("Revisiting: "+val.key);
		moveToEnd(val);
		printList();		
	}
	
	private void moveToEnd(Value val) {
		if (val == tail) {
			return;
		}
		
		if (val == head) {
			head = head.next;
		} else {
			val.prev.next = val.next;
			val.next.prev = val.prev;
		}
		val.prev = tail;			
		tail.next = val;
		tail = val;
		val.next = null;
	}
	
	private Value poll() {
		if (head == null) {
			return null;
		}
		Value oldVal = head;
		head = head.next;
		head.prev = null;
		return oldVal;
	}

	private void pour(Value val) {
		if (tail == null) {
			tail = val;
			head = val;
			return;
		}
		tail.next = val;
		val.prev = tail;
		tail = val;
	}	
	
	private void printList() {
		Value tmp = head;
		while (tmp != null) {
			System.out.print(tmp+":");
			tmp = tmp.next;
		}
		System.out.println("");
	}
}
