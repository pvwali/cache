package com.ds.cache.client;

import org.junit.Test;

import com.cache.client.DistributedCacheClient;
import com.cache.client.LocalCacheClient;
import com.cache.client.RingCacheClient;

public class CacheClientTest {

//	@Test
	public void testRunLocalCacheClient() throws InterruptedException {
		LocalCacheClient lcc = new LocalCacheClient();
		lcc.init();
	}
	
//	@Test
	public void testRunDCacheClient() throws InterruptedException {
		DistributedCacheClient dcc = new DistributedCacheClient();
		dcc.init();
	}	
	
	@Test
	public void testRunRingCacheClient() throws InterruptedException {
		RingCacheClient rcc = new RingCacheClient();
		rcc.init();
	}	
}
