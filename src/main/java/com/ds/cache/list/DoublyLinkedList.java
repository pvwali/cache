package com.ds.cache.list;


public class DoublyLinkedList {
	Value head, tail;
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}
	
	/**
	 * Moves to end of list
	 * @param val
	 */
	public void moveToEnd(Value val) {
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
	
	/**
	 * Removes from head of list
	 * @return
	 */
	public Value poll() {
		if (head == null) {
			return null;
		}
		Value oldVal = head;
		head = head.next;
		head.prev = null;
		return oldVal;
	}

	/**
	 * Adds to end of list
	 * @param val
	 */
	public void pour(Value val) {
		if (tail == null) {
			tail = val;
			head = val;
			return;
		}
		tail.next = val;
		val.prev = tail;
		tail = val;
	}
	
	/**
	 * Prints the list head to tail
	 */
	public void printList() {
		Value tmp = head;
		while (tmp != null) {
			System.out.print(tmp+":");
			tmp = tmp.next;
		}
		System.out.println("");
	}
}
