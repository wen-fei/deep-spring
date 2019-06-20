package com.wds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : TenYun
 * @date : 2019-06-20 21:15
 * @description :
 **/
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TraceApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/trace-2")
    public String trace() {
        logger.info("===<call trace-2>===");
        return "Trace-2";
    }

    public static void main(String[] args) {
        SpringApplication.run(TraceApplication.class, args);
    }
}
