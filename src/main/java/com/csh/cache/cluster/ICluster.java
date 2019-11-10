package com.csh.cache.cluster;

import java.util.Set;


public interface ICluster<N> {
	public void addNode(N n);
	public N removeNode(int nodeKey);
	
	public N getNode(int nodeKey);
	public Set<N> getAllNodes();
}
