package com.wds.ioc;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author : TenYun
 * @date : 2019-06-02 16:13
 * @description : main test
 **/
public class Main {

    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("spring-bean.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

//        BeanPostProcessorTest test = (BeanPostProcessorTest) factory.getBean("beanPostProcessorTest");
//        test.display();

        factory.addBeanPostProcessor(new LifeCycleBean());

        LifeCycleBean lifeCycleBean = (LifeCycleBean) factory.getBean("lifeCycle");
        lifeCycleBean.display();

        System.out.println("方法调用完成，容器开始关闭...");
        factory.destroySingletons();
    }
}
