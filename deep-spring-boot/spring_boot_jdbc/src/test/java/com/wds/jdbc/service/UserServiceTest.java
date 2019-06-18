package com.wds.jdbc.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.wds.jdbc.JDBCApplication;
import com.wds.jdbc.dao.UserRepository;
import com.wds.jdbc.pojo.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JDBCApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @Before
//    public void setUp() {
//        userService.deleteAllUsers();
//    }

    @Test
    public void test() throws Exception {
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);

        Assert.assertEquals(5, userService.getAllUsers().intValue());

        userService.deleteByName("a");
        userService.deleteByName("b");
        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }


    @Test
    public void test2() throws Exception {
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));


        Assert.assertEquals(6, userRepository.findAll().size());

        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().intValue());

        Assert.assertEquals(60, userRepository.findUser("FFF").getAge().intValue());

        userRepository.delete(userRepository.findByName("AAA"));

        Assert.assertEquals(5, userRepository.findAll().size());
    }
}