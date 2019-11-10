package com.csh.cache.hash;

public class RingHash implements IHash<Integer, Integer> {
	int hi, lo;
	public RingHash(int hi, int lo) {
		this.hi = hi;
		this.lo -= lo;
	}
	
	/**
	 * Generates a hashkey for the given value v,
	 *  whose key lies b/w default hi & low
	 */
	@Override
	public Integer hashKey(Integer v) {
		return hashKeyWithIn(v, this.hi, this.lo);
	}

	
	/**
	 * Generates a haskey for the given value v,
	 *  b/w the custom hi & lo
	 */
	@Override
	public Integer hashKeyWithIn(Integer v, int hi, int lo) {
		return (v % (hi-lo)) + lo;
	}
}
