package com.ds.cache.client;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ds.cache.Cache;
import com.ds.cache.SimpleLRUCache;


public class CacheClient {
	ExecutorService executor;
	Cache<Integer, Integer> myCache;
	Random r = new Random();
	
	public CacheClient() {
		executor = Executors.newFixedThreadPool(5);
		myCache = new SimpleLRUCache(10);
	}
	
	public void init() {
		for (int i=0; i<5; i++) {
			executor.submit(() -> {
				try {
					do {
						myCache.get(r.nextInt(20));
						Thread.sleep(1000);
					} while(true);
				} catch (Exception e) {
				}
			});
		}
	}
}
