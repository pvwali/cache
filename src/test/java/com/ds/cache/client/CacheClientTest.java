package com.ds.cache.client;

import org.junit.Test;

import com.cache.client.DistributedCacheClient;
import com.cache.client.LocalCacheClient;

public class CacheClientTest {

	@Test
	public void testRunLocalCacheClient() throws InterruptedException {
		LocalCacheClient lcc = new LocalCacheClient();
		lcc.init();
	}
	
	@Test
	public void testRunDCacheClient() throws InterruptedException {
		DistributedCacheClient dcc = new DistributedCacheClient();
		dcc.init();
	}	
}
