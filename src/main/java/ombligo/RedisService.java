package ombligo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

@Service
@Slf4j
class RedisService {

    private final JedisPool jedisPool;

    public RedisService(@Value("${redis.host}") String host,
                        @Value("${redis.port}") int port,
                        @Value("${redis.ssl}") boolean ssl) {
        jedisPool = new JedisPool(new JedisPoolConfig(), host, port, ssl);
    }

    String get(String key) {
        log.trace("get(): key={}", key);
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
    }


    Set<String> getMembers(String key) {
        log.trace("get(): key={}", key);
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.smembers(key);
        }
    }

}