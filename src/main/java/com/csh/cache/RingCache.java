package com.csh.cache;

import java.util.HashSet;
import java.util.Set;

import com.cache.ICache;
import com.csh.cache.cluster.ICluster;
import com.csh.cache.cluster.RingCluster;
import com.csh.cache.node.Node;

public class RingCache implements ICache<Integer, Integer> {

	ICluster<Node> rc;
	public RingCache() {
		rc = RingCluster.createCluster(3); // creates a cluster of 3 nodes
	}
	
	@Override
	public Integer get(Integer k) {
		return rc.getNode(k).get(k);
	}

	@Override
	public Set<Integer> keys() {
		Set<Integer> keys = new HashSet<>();
		for (Node n: rc.getAllNodes()) {
			keys.addAll(n.keys());
		}
		return keys;
	}
}
