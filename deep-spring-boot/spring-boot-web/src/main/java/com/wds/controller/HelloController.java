package com.wds.controller;

import com.wds.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello world
 *
 * @author : TenYun
 * @date : 2019-05-29 12:21
 **/
/**
 * 此注释默认类中的方法都会以 json 的格式返回
 */
@RestController
public class HelloController {

    @RequestMapping("/user")
    public User getUser() {
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        return user;
    }
}
