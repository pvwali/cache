package com.csh.cache.hash;

public interface IHash<K,V> {
	public K hashKey(V v);
	public K hashKeyWithIn(V v, int hi, int lo);
}
