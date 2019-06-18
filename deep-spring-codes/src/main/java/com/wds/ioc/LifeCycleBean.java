package com.wds.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author : TenYun
 * @date : 2019-06-02 18:57
 * @description : bean life cycle test
 **/
public class LifeCycleBean implements BeanNameAware,
        BeanFactoryAware, BeanClassLoaderAware,
        BeanPostProcessor, InitializingBean, DisposableBean {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        System.out.println("属性注入...");
        this.test = test;
    }

    public LifeCycleBean() {
        System.out.println("构造函数调用...");
    }

    public void display() {
        System.out.println("方法调用...");
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAware 被调用...");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware 被调用...");
    }

    public void setBeanName(String name) {
        System.out.println("BeanNameAware 被调用...");
    }

    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy 被调动...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet 被调动...");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor postProcessBeforeInitialization 被调用...");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor postProcessAfterInitialization 被调用...");
        return bean;
    }

    public void initMethod(){
        System.out.println("init-method 被调用...");
    }

    public void destroyMethod(){
        System.out.println("destroy-method 被调用...");
    }
}
