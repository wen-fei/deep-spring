package com.wds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author : TenYun
 * @date : 2019-06-20 16:55
 * @description :
 **/
@SpringBootApplication
@EnableConfigServer
public class BaseConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseConfigApplication.class, args);
    }
}
