package com.xyscm.sys.basic.cas.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RedisCache implements Cache {

	private Logger logger;
	private RedisSerializer serializer;
	private RedisManager cache;
	private String keyPrefix;

	public String getKeyPrefix() {
		return keyPrefix;
	}

	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

	public void setSerializer(RedisSerializer serializer) {
		this.serializer = serializer;
	}

	public RedisCache(RedisManager cache) {
		logger = LoggerFactory.getLogger(getClass());
		serializer = new JdkSerializationRedisSerializer();
		keyPrefix = "shiro_redis_session:";
		if (cache == null) {
			throw new IllegalArgumentException("Cache argument cannot be null.");
		} else {
			this.cache = cache;
			return;
		}
	}

	public RedisCache(RedisManager cache, String prefix) {
		this(cache);
		keyPrefix = prefix;
	}

	private byte[] getByteKey(Object key) {
		if (key instanceof String) {
			String preKey = (new StringBuilder(String.valueOf(keyPrefix)))
					.append(key).toString();
			return preKey.getBytes();
		} else {
			return serializer.serialize(key);
		}
	}

	public Object get(Object key) throws CacheException {
		if (key == null)
			return null;

		try {
			Object value;
			byte rawValue[] = cache.get(getByteKey(key));
			value = serializer.deserialize(rawValue);
			return value;
		} catch (Throwable t) {

			throw new CacheException(t);

		}
	}

	public Object put(Object key, Object value) throws CacheException {

		try {
			cache.set(getByteKey(key), serializer.serialize(value));
			return value;
		} catch (Throwable t) {
			throw new CacheException(t);
		}

	}

	public Object remove(Object key) throws CacheException {
		try {
			Object previous = get(key);

			cache.del(getByteKey(key));
			return previous;
		} catch (Throwable t) {
			throw new CacheException(t);
		}

	}

	public void clear() throws CacheException {
		try {
			cache.flushDB();
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	public int size() {
		try {
			Long longSize = new Long(cache.dbSize().longValue());
			return longSize.intValue();
		} catch (Throwable t) {
			throw new CacheException(t);
		}

	}

	public Set keys() {
		try {
			Set keys = cache
					.keys((new StringBuilder(String.valueOf(keyPrefix)))
							.append("*").toString());
			if (CollectionUtils.isEmpty(keys))
				return Collections.emptySet();
			Set newKeys;
			newKeys = new HashSet();
			byte key[];
			for (Iterator iterator = keys.iterator(); iterator.hasNext(); newKeys
					.add(key))
				key = (byte[]) iterator.next();

			return newKeys;
		} catch (Throwable t) {
			throw new CacheException(t);
		}

	}

	public Collection values() {
		List values;
		try {
			Set keys = cache
					.keys((new StringBuilder(String.valueOf(keyPrefix)))
							.append("*").toString());
			if (CollectionUtils.isEmpty(keys)) {
				return Collections.emptyList();
			} else {
				values = new ArrayList(keys.size());
				for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
					byte key[] = (byte[]) iterator.next();
					Object value = get(key);
					if (value != null)
						values.add(value);
				}

				return Collections.unmodifiableList(values);
			}
		} catch (Throwable t) {
			throw new CacheException(t);
		}

	}

}
