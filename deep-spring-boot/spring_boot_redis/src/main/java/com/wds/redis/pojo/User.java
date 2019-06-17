package com.wds.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : TenYun
 * @date : 2019-06-17 16:19
 * @description :
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    public static final long serialVersionUID = -1L;

    public String username;

    public Integer age;
}
