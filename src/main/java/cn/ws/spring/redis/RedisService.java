package cn.ws.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import java.nio.charset.StandardCharsets;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-12-28 10:38
 */
public class RedisService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void set(){
        redisTemplate.execute((RedisCallback<Object>) redisConnection ->
                redisConnection.set(
                        "a".getBytes(StandardCharsets.UTF_8)
                        ,"b".getBytes(StandardCharsets.UTF_8)
                        , Expiration.seconds(1000L), RedisStringCommands.SetOption.UPSERT
                )
        );
    }
}
