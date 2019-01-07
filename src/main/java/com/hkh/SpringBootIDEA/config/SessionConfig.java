package com.hkh.SpringBootIDEA.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class SessionConfig {
    //maxInactiveIntervalInSeconds优先级高于server.session.timeout
}
