package cache;

import org.junit.Test;

import com.ds.cache.client.CacheClient;

public class CacheClientTest {

	@Test
	public void test() {
		CacheClient cc = new CacheClient();
		cc.init();
		System.out.println();
	}
}
