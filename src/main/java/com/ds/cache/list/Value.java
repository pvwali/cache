package com.ds.cache.list;

public class Value {
	int key;
	int val;
	int freq;
	Value prev;
	Value next;
	
	public Value(int key, int val) {
		this.key = key;
		this.val = val;
		this.freq = 0;
	}
	
	public int getVal() {
		return val;
	}
	
	public int getKey() {
		return key;
	}
	
	public int getFreq() {
		return freq;
	}
	
	public void incrFreq() {
		this.freq++;
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
