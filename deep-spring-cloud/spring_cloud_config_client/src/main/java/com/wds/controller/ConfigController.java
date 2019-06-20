package com.wds.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : TenYun
 * @date : 2019-06-20 19:18
 * @description :
 **/
@RefreshScope
@RestController
public class ConfigController {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/from", method = RequestMethod.GET)
    public String from() {
        return this.from;
    }
}
