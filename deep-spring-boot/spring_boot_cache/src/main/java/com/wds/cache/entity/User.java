package com.wds.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author : TenYun
 * @date : 2019-06-17 19:31
 * @description :
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
