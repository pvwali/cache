package com.cache.client;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cache.ICache;
import com.ds.cache.local.LocalLFUCache;


public class LocalCacheClient {
	ExecutorService executor;
	ICache<Integer, Integer> myCache;
	Random r = new Random();
	
	public LocalCacheClient() {
		executor = Executors.newFixedThreadPool(5);
		myCache = new LocalLFUCache(10);
	}
	
	public void init() throws InterruptedException {
		for (int i=0; i<5; i++) {
			executor.submit(() -> {
				try {
					do {
						myCache.get(r.nextInt(20));
						Thread.sleep(100);
					} while(true);
				} catch (Exception e) {
				}
			});
		}
		
		// Running the simulation for 10sec
		Thread.sleep(1000*10);
		executor.shutdownNow();		
		while (!executor.isTerminated()) {
			Thread.sleep(1000);
		}
	}
}
