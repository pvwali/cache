package com.cache.client;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cache.ICache;
import com.csh.cache.RingCache;

public class RingCacheClient {
	ExecutorService executor;
	ICache<Integer, Integer> myCache;

	public RingCacheClient() {
		executor = Executors.newFixedThreadPool(5);
		myCache = new RingCache();
	}
	
	public void init() throws InterruptedException {
		Random r = new Random();
		for (int i=0; i<5; i++) {
			executor.submit(
				() -> {
					try {
						do {
							myCache.get(r.nextInt(50_000));
							Thread.sleep(100);
						} while(true);
					} catch (Exception e) {
					}
				}
			);
		}
		
		// Running the simulation for 20sec
		Thread.sleep(1000*20);
		executor.shutdownNow();		
		while (!executor.isTerminated()) {
			Thread.sleep(1000);
		}		
	}
}
