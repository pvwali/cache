package com.ds.cache;

public class Value {
	int key;
	int val;
	Value prev;
	Value next;
	
	public Value(int key, int val) {
		this.key = key;
		this.val = val;
		this.prev = null;
		this.next = null;
	}
	
	public int getVal() {
		return val;
	}
	
	public int getKey() {
		return key;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Value) {
			return (obj == null)? false :
				this.key==((Value)obj).key;			
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.key+"";
	}
}
