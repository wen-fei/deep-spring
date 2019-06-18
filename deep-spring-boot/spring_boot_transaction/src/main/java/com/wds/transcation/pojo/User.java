package com.wds.transcation.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Entity
public class User implements Serializable {

    public static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false, length = 5)
    public String name;

    @Column(nullable = false)
    public Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
