package net.engineeringdigest.journalApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory)
    {
        // RedisConnectionFactory is interface Spring automatically injects concrete implementation to build connection
        RedisTemplate redisTemplate= new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());  //same serializer used in deserialization also
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        return redisTemplate;
    }
}
