package com.wds.datasources.mapper;

import com.wds.datasources.annotation.DataSource;
import com.wds.datasources.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author : TenYun
 * @date : 2019-06-17 13:22
 * @description :
 **/
@Component
public interface UserMapper extends JpaRepository<User, String> {
    @DataSource("slave1")
    User findByName(String name);

    @Override
    @DataSource("slave1")
    User save(User user);
}
