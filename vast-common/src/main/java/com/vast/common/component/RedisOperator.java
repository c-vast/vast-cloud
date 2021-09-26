package com.vast.common.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 使用redisTemplate的操作实现类
 */
@Component
public class RedisOperator {

	@Autowired
	private RedisTemplate redisTemplate;


	public Set<String> keys(String pattern) {
		return redisTemplate.keys(pattern);
	}

	public void del(String key) {
		redisTemplate.delete(key);
	}

	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public void set(String key, String value, long timeout) {
		redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
	}

	public String get(String key) {
		return (String)redisTemplate.opsForValue().get(key);
	}

    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

	public void hset(String key, String field, Object value) {
		redisTemplate.opsForHash().put(key, field, value);
	}

	public String hget(String key, String field) {
		return (String) redisTemplate.opsForHash().get(key, field);
	}

	public void hdel(String key, Object... fields) {
		redisTemplate.opsForHash().delete(key, fields);
	}

	public Map<Object, Object> hgetall(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	public List<String> getValues(Collection<String> keys){
		return redisTemplate.opsForValue().multiGet(keys);
	}
}