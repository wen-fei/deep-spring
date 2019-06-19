package com.wds.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wds.hystrix.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;
/**
 * @author : TenYun
 * @date : 2019-06-19 20:07
 * @description :
 **/
@Service
public class UserService {


    @Autowired
    private RestTemplate restTemplate;

    /**
     * 注解可以定义Hystrix命令的实现，但是只能是同步执行的方式，异步执行需要自己定义
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "defaultUser")
    public User getUserById(Long id) {
        return restTemplate.getForObject("http://USER_SERVICE/user/{1}", User.class, id);
    }


    /**
     * 异步执行
     * @param id
     * @return
     */
//    @HystrixCommand
//    public Future<User> geyUserByIdAsync(final String id) {
//        return new AsyncResult<User>() {
//            @Override
//            public User invoke() {
//                return new restTemplate.getForObject("http://USER-SERVICE/user/{1}", User.class, id);
//            }
//        };
//    }

    @HystrixCollapser(batchMethod = "findAll",
            collapserProperties = {@HystrixProperty(name="timerDelayInMilliseconds", value = "100")})
    public User find(Long id) {
        return null;
    }

    @HystrixCommand
    public List<User> findAll(List<Long> ids) {
        return restTemplate.getForObject("http://USER-SERVICE/users?id={1}",
                List.class,
                StringUtils.join(ids, ","));
    }

    private User defaultUser() {
        return new User();
    }
}
