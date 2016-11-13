package com.bofowo.cache;

import net.sf.ehcache.Ehcache;

public class CacheProvider {
	private static Ehcache cache;
	public CacheProvider(){}
	public CacheProvider(Ehcache cache){
		this.cache=cache;
	}
	public static Ehcache getCache() {
		return cache;
	}
	public static void setCache(Ehcache cache) {
		CacheProvider.cache = cache;
	}

}
