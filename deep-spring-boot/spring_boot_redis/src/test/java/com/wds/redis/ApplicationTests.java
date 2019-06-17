package com.wds.redis;

import com.wds.redis.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : TenYun
 * @date : 2019-06-17 15:22
 * @description :
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        redisTemplate.opsForValue().set("aaa", 111);
        Assert.assertEquals(111, redisTemplate.opsForValue().get("aaa"));
    }


    @Test
    public void test2() throws Exception {
        User user = new User("张三", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("李四", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("麻五", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        User user2  = (User) redisTemplate.opsForValue().get("张三");
        Assert.assertEquals(20, user2.getAge().intValue());
        user2 = (User) redisTemplate.opsForValue().get("李四");
        Assert.assertEquals(30, user2.getAge().intValue());
        user2 = (User) redisTemplate.opsForValue().get("麻五");
        Assert.assertEquals(40,user2.getAge().intValue());
    }
}
