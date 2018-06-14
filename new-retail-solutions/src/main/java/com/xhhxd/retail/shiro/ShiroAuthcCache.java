package com.xhhxd.retail.shiro;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.xhhxd.retail.bean.bs.BsUser;
import com.xhhxd.retail.common.SerializeFactory;
import com.xhhxd.retail.common.serialize.Serialization;
import com.xhhxd.retail.common.serialize.Serialization.SerializeType;
import com.xhhxd.retail.util.JsonUtil;
import com.xhhxd.retail.util.ShiroUtil;

@SuppressWarnings("unchecked")
public class ShiroAuthcCache<K, V> implements Cache<K, V> {
	private final static Logger logger = LoggerFactory.getLogger(ShiroAuthcCache.class);

	private final String keyPrefix = ShiroUtil.DEFAULT_SHIRO_CACHE;
	
	private String name;
	
	private Serialization serialize;

	public ShiroAuthcCache(String name) {
		//if (redisManager == null)
		//	throw new IllegalArgumentException("cache argument cannot be null.");

		this.name = name;
		this.serialize = SerializeFactory.build(SerializeType.JavaBean);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public V get(K key) throws CacheException {
		try {
			String bKey = buildKey(key);
			//byte[] bValue = redisManager.getByte(bKey);
			//return (V) serialize.deserialize(bValue);
		} catch (Exception e) {
			logger.error("get error {}", e);
		}
		return null;
	}

	@Override
	public Set<K> keys() {
		return Collections.emptySet();
	}

	@Override
	public V put(K key, V value) throws CacheException {
		V previos = get(key);
		try {
			String bKey = buildKey(key);
			byte[] bValue = serialize.serialize(value);
			//redisManager.setByte(bKey, bValue);
		} catch (Exception e) {
			logger.error("put error {}", e);
		}
		return previos;
	}

	@Override
	public V remove(K key) throws CacheException {
		V previous = get(key);
		try {
			String bKey = buildKey(key);
		} catch (Exception e) {
			logger.error("remove error {}", e);
		}
		return previous;
	}

	@Override
	public int size() {
		Set<K> keys = this.keys();
		return keys.size();
	}

	@Override
	public Collection<V> values() {
		return Collections.emptyList();
	}

	@Override
	public void clear() throws CacheException {
		try {
			String key = keyPrefix + this.getName() + "*";
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	private String buildKey(K key) {
		Object bKey = key;
		if (key instanceof BsUser) {
			BsUser user = (BsUser) key;
			bKey = user.getUsername();
		} else if (key instanceof SimplePrincipalCollection) {
			BsUser user = JsonUtil.parseObject(key.toString(), BsUser.class);
			bKey = user.getUsername();
		}
		return keyPrefix + this.getName() + bKey;
	}
}