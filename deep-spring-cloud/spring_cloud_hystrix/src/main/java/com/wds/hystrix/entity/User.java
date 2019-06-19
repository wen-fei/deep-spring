package com.wds.hystrix.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : TenYun
 * @date : 2019-06-19 20:03
 * @description :
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public Long id;

    public String name;

    public Integer age;
}
