package com.wds.datasources;

import com.wds.datasources.annotation.DataSource;
import com.wds.datasources.mapper.UserMapper;
import com.wds.datasources.pojo.User;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : TenYun
 * @date : 2019-06-17 13:27
 * @description :
 **/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void save() {

        userMapper.save(new User("AAA", 10));
        userMapper.save(new User("BBB", 20));
        userMapper.save(new User("CCC", 30));
        userMapper.save(new User("DDD", 40));
        userMapper.save(new User("EEE", 50));
        userMapper.save(new User("FFF", 60));

        Assert.assertEquals(6, userMapper.findAll().size());
    }
}
