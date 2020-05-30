package org.wds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.wds.pojo.Quote;

/**
 * @author : TenYun
 * @date : 2020-05-29 13:22
 * @description : 日志记录、RestTemplate使用
 **/
@SpringBootApplication
public class RestfulApplication {

    // 日志记录，可以发送到控制台、文件等
    private static final Logger log = LoggerFactory.getLogger(RestfulApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestfulApplication.class, args);
    }

    /**
     * 使用Jackson JSON处理传入的数据
     * 用于解析网络API接口返回json格式数据时场景
     * @param builder
     * @return
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    /**
     * 程序启动时运行RestTemplate
     * @param restTemplate
     * @return
     */
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            // 将数据写到控制台
            log.info(quote.toString());
        };
    }


}
