package com.shiwulian.wechat.core.cache;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shiwulian.wechat.util.JsonUtil;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class ShardedJedisManager {
	protected final static Logger logger = LoggerFactory.getLogger(RedisManager.class);

	private final static int DEFAULT_EXPIRE_TIME = 10 * 60;

	private final static String DEFAULT_REDIS_CACHE = "redis_cache_";

	private int expire = DEFAULT_EXPIRE_TIME;

	private String keyPrefix = DEFAULT_REDIS_CACHE;

	private ShardedJedisPool shardedJedisPool;

	public ShardedJedisManager(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}

	public Boolean setByte(byte[] key, byte[] value) {
		return setByte(key,value,expire);
	}

	public Boolean setByte(byte[] key, byte[] value, int seconds) {
		return excute(jedis -> {
			jedis.expire(key, seconds);
			String ret = jedis.set(key, value);
			return "OK".equalsIgnoreCase(ret);
		});
	}
	
	public <T> Boolean setMap(String key, Map<String, T> map) {
		return setMap(key, map, expire);
	}

	public <T> Boolean setMap(String key, Map<String, T> map, int seconds) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			String json = JsonUtil.toJSON(map);
			jedis.expire(ckey, seconds);
			String ret = jedis.set(ckey, json);
			return "OK".equalsIgnoreCase(ret);
		});
	}
	
	public <T> Boolean setMaps(String key, Map<String, List<T>> maps) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			String json = JsonUtil.toJSON(maps);
			jedis.expire(ckey, expire);
			String ret = jedis.set(ckey, json);
			return "OK".equalsIgnoreCase(ret);
		});
	}

	public <T> Boolean setMaps(String key, Map<String, List<T>> maps, int seconds) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			String json = JsonUtil.toJSON(maps);
			jedis.expire(ckey, expire);
			String ret = jedis.set(ckey, json);
			return "OK".equalsIgnoreCase(ret);
		});
	}

	public Boolean setString(String key, String value) {
		return setString(key, value, expire);
	}

	public Boolean setString(String key, String value, int seconds) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			jedis.expire(ckey, seconds);
			String ret = jedis.set(ckey, value);
			return "OK".equalsIgnoreCase(ret);
		});
	}

	public Boolean setObject(String key, Object value) {
		return setObject(key, value, expire);
	}

	public Boolean setObject(String key, Object value, int seconds) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			jedis.expire(ckey, seconds);
			String objJson = JsonUtil.toJSON(value);
			String ret = jedis.set(ckey, objJson);
			return "OK".equalsIgnoreCase(ret);
		});
	}

	public Boolean setObjectMap(String key, Map<String, Object> map) {
		return setObjectMap(key, map, expire);
	}

	public Boolean setObjectMap(String key, Map<String, Object> map, int seconds) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			jedis.expire(ckey, seconds);
			String objJson = JsonUtil.toJSON(map);
			String ret = jedis.set(ckey, objJson);
			return "OK".equalsIgnoreCase(ret);
		});
	}

	public Boolean setStringMap(String key, Map<String, String> map) {
		return setStringMap(key, map, expire);
	}

	public Boolean setStringMap(String key, Map<String, String> map, int seconds) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			jedis.expire(ckey, seconds);
			String objJson = JsonUtil.toJSON(map);
			String ret = jedis.set(ckey, objJson);
			return "OK".equalsIgnoreCase(ret);
		});
	}

	public <T> Boolean setList(String key, List<T> values) {
		return setList(key, values, expire);
	}

	public <T> Boolean setList(String key, List<T> values, int seconds) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			jedis.expire(ckey, seconds);
			String objJson = JsonUtil.toJSON(values);
			String ret = jedis.set(ckey, objJson);
			return "OK".equalsIgnoreCase(ret);
		});
	}

	public byte[] getByte(byte[] key) {
		return excute(jedis -> {
			return jedis.get(key);
		});
	}
	
	public String getString(String key) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			return jedis.get(ckey);
		});
	}

	public Object getObject(String key) {
		return getObject(key, Object.class);
	}

	public <T> T getObject(String key, Class<T> clazz) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			String json = jedis.get(ckey);
			return JsonUtil.parseObject(json, clazz);
		});
	}

	public Map<String, String> getStringMap(String key) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			return jedis.hgetAll(ckey);
		});
	}

	public Map<String, Object> getObjectMap(String key) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			String value = jedis.get(ckey);
			return JsonUtil.parseObjectMap(value);
		});
	}

	public <T> Map<String, T> getMap(String key, Class<T> clazz) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			String json = jedis.get(ckey);
			return JsonUtil.parseMap(json, clazz);
		});
	}

	public <T> Map<String, List<T>> getMaps(String key, Class<T> clazz) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			String json = jedis.get(ckey);
			return JsonUtil.parseMaps(json, clazz);
		});
	}

	public <T> List<T> getList(String key, Class<T> clazz) {
		return excute(jedis -> {
			String ckey = buildKey(key);
			String value = jedis.get(ckey);
			return JsonUtil.parseArray(value, clazz);
		});
	}

	public Boolean exists(String key) {
		return excute(jedis -> {
			return jedis.exists(buildKey(key));
		});
	}

	public Long del(String key) {
		return excute(jedis -> {
			return jedis.del(buildKey(key));
		});
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public String getKeyPrefix() {
		return keyPrefix;
	}

	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

	private <T> T excute(Function<ShardedJedis, T> callback) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			return callback.apply(shardedJedis);
		} catch (JedisConnectionException e) {
			logger.error("JedisConnection error {}", e);
		} catch (Exception e) {
			logger.error("jedis excute error {}", e);
		} finally {
			if (null != shardedJedis) {
				shardedJedis.close();
			}
		}
		return null;
	}

	private String buildKey(Object key) {
		return keyPrefix + ":" + key;
	}
}
