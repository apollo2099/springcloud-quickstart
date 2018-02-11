package com.spring.cloud.quick;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by huixiong on 2018/2/11.
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages={"com.spring.cloud.quick"})
public class Application {


    public static void main(String[] args){
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }


}
