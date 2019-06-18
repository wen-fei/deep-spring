package com.wds.jdbc.service;

import org.springframework.stereotype.Service;

/**
 * @author : TenYun
 * @date : 2019-06-17 9:03
 * @description :
 **/

public interface UserService {

    void create(String name, Integer age);

    void deleteByName(String name);

    Integer getAllUsers();

    void deleteAllUsers();

}
