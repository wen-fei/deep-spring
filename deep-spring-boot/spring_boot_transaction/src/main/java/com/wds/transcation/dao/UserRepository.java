package com.wds.transcation.dao;

import com.wds.transcation.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * @author : TenYun
 * @date : 2019-06-17 9:05
 * @description :
 **/
@Component
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query(value = "select id, name, age from user u where u.name=:name", nativeQuery = true)
    User findUser(@Param("name") String name);
}
