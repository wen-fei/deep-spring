package com.wds;

import com.wds.transcation.TranscationApplication;
import com.wds.transcation.dao.UserRepository;
import com.wds.transcation.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : TenYun
 * @date : 2019-06-17 18:09
 * @description :
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TranscationApplication.class)
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void test() throws Exception {
        // 创建10条记录
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHHHHHHHHHHHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));
    }


}
