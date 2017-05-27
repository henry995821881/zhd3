package com.xyscm.sys.basic.cas.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * 
 * 功能描述：
 * 
 * @author xielf
 * @CreateDate 2017-5-18 下午1:07:39
 * @Version: 1.0
 */
public class RedisSessionDAO extends AbstractSessionDAO {

	private static Logger logger = LoggerFactory
			.getLogger(RedisSessionDAO.class.getName());
	private RedisSerializer serializer;
	private RedisManager redisManager;
	private String keyPrefix;

	public RedisSessionDAO() {
		serializer = new JdkSerializationRedisSerializer();
		keyPrefix = "shiro_redis_session:";
	}

	public void update(Session session) throws UnknownSessionException {
		saveSession(session);
	}

	private void saveSession(Session session) throws UnknownSessionException {
		if (session == null || session.getId() == null) {
			logger.error("session or session id is null");
			return;
		} else {
			byte key[] = getByteKey(session.getId());
			byte value[] = serializer.serialize(session);
			session.setTimeout(redisManager.getExpire() * 1000);
			redisManager.set(key, value, redisManager.getExpire());
			return;
		}
	}

	public void delete(Session session) {
		if (session == null || session.getId() == null) {
			logger.error("session or session id is null");
			return;
		} else {
			redisManager.del(getByteKey(session.getId()));
			return;
		}
	}

	public Collection getActiveSessions() {
		Set sessions = new HashSet();
		Set keys = redisManager.keys((new StringBuilder(String
				.valueOf(keyPrefix))).append("*").toString());
		if (keys != null && keys.size() > 0) {
			Session s;
			for (Iterator iterator = keys.iterator(); iterator.hasNext(); sessions
					.add(s)) {
				byte key[] = (byte[]) iterator.next();
				s = (Session) serializer.deserialize(redisManager.get(key));
			}

		}
		return sessions;
	}

	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		saveSession(session);
		return sessionId;
	}

	protected Session doReadSession(Serializable sessionId) {
		if (sessionId == null) {
			logger.error("session id is null");
			return null;
		} else {
			Session s = (Session) serializer.deserialize(redisManager
					.get(getByteKey(sessionId)));
			return s;
		}
	}

	private byte[] getByteKey(Serializable sessionId) {
		String preKey = (new StringBuilder(String.valueOf(keyPrefix))).append(
				sessionId).toString();
		return preKey.getBytes();
	}

	public void setSerializer(RedisSerializer serializer) {
		this.serializer = serializer;
	}

	public RedisManager getRedisManager() {
		return redisManager;
	}

	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
		this.redisManager.init();
	}

	public String getKeyPrefix() {
		return keyPrefix;
	}

	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

}
