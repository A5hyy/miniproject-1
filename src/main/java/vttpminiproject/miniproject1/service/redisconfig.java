package vttpminiproject.miniproject1.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


import vttpminiproject.miniproject1.model.RecipeModel;

@Configuration
public class redisconfig {
    private static final Logger logger = LoggerFactory.getLogger(redisconfig.class);

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private Optional<Integer> redisPort;

    @Value("${spring.redis.password}")
    private String redisPassword;

    // @Value("${spring.redis.database}")
    // private String redisDatabase;

    @Bean(name = "games")
    @Scope("singleton")
    public RedisTemplate<String, RecipeModel> redisTemplate() {
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(redisHost);
        config.setPort(redisPort.get());
        config.setPassword(redisPassword);
        Jackson2JsonRedisSerializer jackson2JsonJsonSerializer = new Jackson2JsonRedisSerializer(RecipeModel.class);

        final JedisClientConfiguration jedisClient = JedisClientConfiguration.builder().build();
        final JedisConnectionFactory jedisFac = new JedisConnectionFactory(config, jedisClient);
        jedisFac.afterPropertiesSet();
        logger.info("redis host port > {redisHost} {redisPort}", redisHost, redisPort);
        RedisTemplate<String, RecipeModel> template = new RedisTemplate<String, RecipeModel>();
        template.setConnectionFactory(jedisFac);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(jackson2JsonJsonSerializer);
        template.setHashKeySerializer(template.getKeySerializer());
        template.setHashValueSerializer(template.getValueSerializer());
        return template;
    }
}