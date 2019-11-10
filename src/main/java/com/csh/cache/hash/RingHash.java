package com.csh.cache.hash;

public class RingHash implements IHash<Integer, Integer> {
	int hi, lo;
	public RingHash(int lo, int hi) {
		this.hi = hi;
		this.lo = lo;
	}
	
	/**
	 * Generates a hashkey for the given value v,
	 *  whose key lies b/w default hi & low
	 */
	@Override
	public Integer hashKey(Integer v) {
		return hashKeyWithIn(v, this.lo, this.hi);
	}

	
	/**
	 * Generates a haskey for the given value v,
	 *  b/w the custom hi & lo
	 */
	@Override
	public Integer hashKeyWithIn(Integer v, int lo, int hi) {
		return (v % (hi-lo)) + lo;
	}
}
