package com.ds.cache.client;

import org.junit.Test;

import com.ds.cache.client.CacheClient;

public class CacheClientTest {

	@Test
	public void test() throws InterruptedException {
		CacheClient cc = new CacheClient();
		cc.init();
	}
}
