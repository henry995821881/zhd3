/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 功能描述：
 * 
 * @author xielf
 * @CreateDate 2017-5-18 上午10:43:18
 * @Version: 1.0
 */
public class RedisCacheManager implements CacheManager {

	private static final Logger logger = LoggerFactory.getLogger(RedisCacheManager.class.getName());
	private final ConcurrentMap caches = new ConcurrentHashMap();
	private RedisManager redisManager;
	private String keyPrefix;

	public RedisCacheManager() {
		keyPrefix = "shiro_redis_cache:";
	}

	public String getKeyPrefix() {
		return keyPrefix;
	}

	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

	public Cache getCache(String name) throws CacheException {

		Cache c = (Cache) caches.get(name);
		if (c == null) {
			redisManager.init();
			c = new RedisCache(redisManager, keyPrefix);
			caches.put(name, c);
		}
		return c;
	}

	/**
	 * @return the cacheManager
	 */
	public RedisManager getRedisManager() {
		return redisManager;
	}

	/**
	 * @param cacheManager the cacheManager to set
	 */
	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}



}
