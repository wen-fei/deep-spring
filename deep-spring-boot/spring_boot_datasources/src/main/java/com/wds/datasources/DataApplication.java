package com.wds.datasources;

import com.wds.datasources.aop.DynamicDataSourceAnnotationAdvisor;
import com.wds.datasources.aop.DynamicDataSourceAnnotationInterceptor;
import com.wds.datasources.registor.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author : TenYun
 * @date : 2019-06-17 10:20
 * @description :
 **/

@SpringBootApplication
@Import(DynamicDataSourceRegister.class)
@EnableTransactionManagement
public class DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }

    @Bean
    public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
        return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
    }
}
