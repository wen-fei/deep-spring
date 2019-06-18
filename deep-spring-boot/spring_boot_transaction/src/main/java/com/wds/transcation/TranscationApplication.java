package com.wds.transcation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : TenYun
 * @date : 2019-06-17 18:07
 * @description :
 **/
@SpringBootApplication
public class TranscationApplication {


    public static void main(String[] args) {
        SpringApplication.run(Transactional.class, args);
    }
}
