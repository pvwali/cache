package com.ds.cache.client;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ds.cache.distributed.DistributedCache;
import com.ds.cache.distributed.IDistributedCache;

public class DistributedCacheClient {
	ExecutorService executor;
	IDistributedCache<Integer, Integer> myCache;
	Random r = new Random();
	
	public DistributedCacheClient() {
		executor = Executors.newFixedThreadPool(5);
		myCache = new DistributedCache();
	}
	
	public void init() throws InterruptedException {
		for (int i=0; i<5; i++) {
			executor.submit(() -> {
				try {
					do {
						myCache.get(r.nextInt(150));
						Thread.sleep(100);
					} while(true);
				} catch (Exception e) {
				}
			});
		}
		
		// Running the simulation for 20sec
		Thread.sleep(1000*20);
		executor.shutdownNow();		
		while (!executor.isTerminated()) {
			Thread.sleep(1000);
		}
	}
}
