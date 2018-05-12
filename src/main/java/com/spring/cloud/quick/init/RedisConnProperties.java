package com.spring.cloud.quick.init;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName RedisConn
 * @Description TODO
 * @Autor liaoxiongjian
 * @Date 2018/5/12 15:08
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConnProperties {
    private String host;
    //prefix+参数名  对应于配置文件config.properties中的spring.redis.*信息
    private int port;
    private String password;
    private int timeout;

    public RedisConnProperties() {
    }

    public RedisConnProperties(String host, int port, String password, int timeout) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
        this.password = password;
    }

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
}