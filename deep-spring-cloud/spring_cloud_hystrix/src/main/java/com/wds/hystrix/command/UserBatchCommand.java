package com.wds.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.wds.hystrix.entity.User;
import com.wds.hystrix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.netflix.hystrix.HystrixCommandGroupKey.Factory.asKey;

/**
 * @author : TenYun
 * @date : 2019-06-19 21:38
 * @description :
 **/
public class UserBatchCommand extends HystrixCommand<List<User>> {

    UserService service;

    List<Long> userIds;


    public UserBatchCommand(UserService userService, List<Long> userIds) {
        super(Setter.withGroupKey(asKey("userServiceCommand")));
        this.userIds = userIds;
        this.service = userService;
    }

    @Override
    protected List<User> run() throws Exception {
        return service.findAll(userIds);
    }
}
