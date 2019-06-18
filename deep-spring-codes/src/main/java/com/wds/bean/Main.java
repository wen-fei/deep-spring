package com.wds.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : TenYun
 * @date : 2019-05-31 16:35
 * @description : main func
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

        Display display = (Display) context.getBean("display");
        display.display();
    }
}
