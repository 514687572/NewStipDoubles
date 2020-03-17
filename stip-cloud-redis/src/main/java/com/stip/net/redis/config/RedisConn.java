package com.stip.net.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description redis连接信息配置类
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConn {
    private String host;

    private String password;

    private int port;

    private int timeout;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Redis [localhost=" + host + ", port=" + port + ", timeout=" + timeout + "]";
    }
}
