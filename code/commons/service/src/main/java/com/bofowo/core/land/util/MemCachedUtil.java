package com.bofowo.core.land.util;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframe.core.util.SpringBeanUtil;

public class MemCachedUtil {
	protected static Logger log = LoggerFactory.getLogger("MemcacheUtil");
	
	public static void put(String key,Object obj,int second){
		try {
			MemcachedClient client=((MemcachedClient)SpringBeanUtil.getBean("memcachedClient"));
			client.delete(key);
			client.add(key, second, obj);
		} catch (TimeoutException e) {
			log.error("occur error when cache key:"+key);
			log.error(e.getMessage());
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		} catch (MemcachedException e) {
			log.error(e.getMessage());
		}
	}
	
	public static Object get(String key){
		try {
			return ((MemcachedClient)SpringBeanUtil.getBean("memcachedClient")).get(key);
		} catch (TimeoutException e) {
			log.error("occur error when cache key:"+key);
			log.error(e.getMessage());
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		} catch (MemcachedException e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	public static void clear(String key){
		try {
			((MemcachedClient)SpringBeanUtil.getBean("memcachedClient")).delete(key);
		} catch (TimeoutException e) {
			log.error(e.getMessage());
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		} catch (MemcachedException e) {
			log.error(e.getMessage());
		}
	}

}
