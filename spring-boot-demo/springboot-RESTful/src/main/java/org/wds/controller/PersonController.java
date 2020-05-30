package org.wds.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wds.pojo.Person;

/**
 * @author : TenYun
 * @date : 2020-05-29 13:25
 * @description :
 **/

@RestController
public class PersonController {

    @GetMapping("/person")
    public Person getPerson(@RequestParam(value = "name", defaultValue = "zhangsan") String name) {
        return new Person(
                "李四",
                "男",
                "上海"
        );

    }
}
