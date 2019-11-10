package com.csh.cache.hash;

public class RingHash implements IHash<Integer, Integer> {
	int hi, lo;
	public RingHash(int hi, int lo) {
		this.hi = hi;
		this.lo -= lo;
	}
	
	@Override
	public Integer hashKey(Integer v) {
		return hashKeyWithIn(v, this.hi, this.lo);
	}

	@Override
	public Integer hashKeyWithIn(Integer v, int hi, int lo) {
		return (v % (hi-lo)) + lo;
	}
}
