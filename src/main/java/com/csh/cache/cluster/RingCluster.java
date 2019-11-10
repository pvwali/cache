package com.csh.cache.cluster;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import com.csh.cache.hash.IHash;
import com.csh.cache.hash.RingHash;
import com.csh.cache.node.Node;

public class RingCluster implements ICluster<Node> {
	TreeMap<Integer, Node> nodes;
	int maxCap = 360;
	IHash<Integer, Integer> hFun;
		
	private static RingCluster rc;
	private RingCluster(int n) {
		nodes = new TreeMap<Integer, Node>();
		hFun = new RingHash(0, 360);

		Random r = new Random();
		for (int i=0; i<n; i++) {
			addNode(new Node(Math.abs(r.nextInt()), 10));
		}
	}
	public static RingCluster createCluster(int n) {
		if (rc == null) {
			rc = new RingCluster(n);
		}
		return rc;
	}
	
	/**
	 * Adds a node to the ring cluster
	 */
	@Override
	public void addNode(Node n) {
		Integer nodeKey = hFun.hashKey(n.getId());
		while (nodes.containsKey(nodeKey)) {
			nodeKey = hFun.hashKey(n.getId());
		}
		n.setClusterKey(nodeKey);
		nodes.put(nodeKey, n);
	}

	/**
	 * Removes a node from the ring cluster
	 */
	@Override
	public Node removeNode(int nodeKey) {
		return nodes.remove(nodeKey);
	}
	
	/**
	 * Returns Node that holds the key
	 * In a Consistent/Ring hash this key resides in the node,
	 *  whose hashkey is greater/equal to the hash of search key
	 */
	@Override
	public Node getNode(int key) {
		Integer nodeKey = hFun.hashKey(key);
		
		Integer nearNodeKey = nodes.ceilingKey(nodeKey);
		if (nearNodeKey==null){
			nearNodeKey = 0;
		}
		return nodes.get(nearNodeKey);
	}
	
	/**
	 * Gets all nodes of a cluster
	 */
	@Override
	public Set<Node> getAllNodes() {
		return new HashSet<>(nodes.values());
	}
	
}
