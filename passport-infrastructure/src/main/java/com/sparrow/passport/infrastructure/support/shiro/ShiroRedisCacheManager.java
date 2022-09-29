package com.sparrow.passport.infrastructure.support.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
 
 
public class ShiroRedisCacheManager implements CacheManager {
 
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<>();
    //TODO:缓存存活时间
    private long cacheLive;
    //TODO:缓存名称前缀
    private String cacheKeyPrefix;
    private RedisTemplate redisTemplate;
 
    public ShiroRedisCacheManager() {
    }
 
    public ShiroRedisCacheManager(long cacheLive, String cacheKeyPrefix, RedisTemplate redisTemplate) {
        this.cacheLive = cacheLive;
        this.cacheKeyPrefix = cacheKeyPrefix;
        this.redisTemplate = redisTemplate;
    }
 
    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        Cache cache = this.caches.get(name);
        if (null == cache) {
            //TODO:自定义Shiro的Cache
            cache = new ShiroRedisCache<K, V>(cacheLive, cacheKeyPrefix, redisTemplate);
            this.caches.put(name, cache);
        }
        return cache;
    }
 
    public long getCacheLive() {
        return cacheLive;
    }
 
    public void setCacheLive(long cacheLive) {
        this.cacheLive = cacheLive;
    }
 
    public String getCacheKeyPrefix() {
        return cacheKeyPrefix;
    }
 
    public void setCacheKeyPrefix(String cacheKeyPrefix) {
        this.cacheKeyPrefix = cacheKeyPrefix;
    }
 
    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }
 
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}