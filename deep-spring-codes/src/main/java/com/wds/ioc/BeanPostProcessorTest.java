package com.wds.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author : TenYun
 * @date : 2019-06-02 16:12
 * @description : BeanPostProcessor Test
 **/
public class BeanPostProcessorTest implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean [" + beanName + "] 开始初始化");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean [" + beanName + "] 完成初始化");
        return bean;
    }

    public void display() {
        System.out.println("hello BeanPostProcessor!!!");
    }
}
