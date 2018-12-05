package pcosee.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import javax.cache.Caching;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.core.config.DefaultConfiguration;
import org.ehcache.expiry.ExpiryPolicy;
import org.ehcache.jsr107.EhcacheCachingProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfig {
    
    @Value("${cache.name}")
    private String cacheNome;
    @Value("${cache.expiration}")
    private int cacheExpiration;
    @Value("${cache.heap}")
    private int cacheHeap;
    
    @Bean
    public CacheManager cacheManager() {
        EhcacheCachingProvider provider = (EhcacheCachingProvider) Caching.getCachingProvider();
        Map<String, CacheConfiguration<?, ?>> caches = new HashMap<>();
        caches.put(this.cacheNome, getPropCache());
        DefaultConfiguration configuration = new DefaultConfiguration(caches, provider.getDefaultClassLoader());
        CacheManager cacheManager = new JCacheCacheManager(provider.getCacheManager(provider.getDefaultURI(), configuration));
        return cacheManager;
    }

    private CacheConfiguration<?, ?> getPropCache() {
        final ResourcePoolsBuilder res = ResourcePoolsBuilder.heap(this.cacheHeap);
        final ExpiryPolicy<Object, Object> expiry = ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(this.cacheExpiration));
        final CacheConfigurationBuilder<Object, Object> newCacheConfigurationBuilder = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Object.class, Object.class, res).withExpiry(expiry);
        return newCacheConfigurationBuilder.build();
    }

}
