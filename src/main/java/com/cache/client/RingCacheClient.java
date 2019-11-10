package com.cache.client;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cache.ICache;
import com.csh.cache.RingCache;

public class RingCacheClient {
	ExecutorService exSvc;
	ICache<Integer, Integer> myCache;

	public RingCacheClient() {
		myCache = new RingCache();
		exSvc = Executors.newFixedThreadPool(5);
		init();
	}
	
	public void init() {
		Random r = new Random();
		for (int i=0; i<5; i++) {
			exSvc.submit(
				() -> {
					try {
						do {
							myCache.get(r.nextInt(20));
							Thread.sleep(100);
						} while(true);
					} catch (Exception e) {
					}
				}
			);
		}
	}
}
