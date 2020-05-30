package org.wds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.wds.dao.CustomerRepository;
import org.wds.entity.Customer;

/**
 * @author : TenYun
 * @date : 2020-05-30 22:14
 * @description : JPA的使用demo
 **/
@SpringBootApplication
public class JPAApplication {

    private static final Logger log = LoggerFactory.getLogger(JPAApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JPAApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            log.info("Customers found with findAll()");
            log.info("------------------------------");

            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }

            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauser").forEach(bauser -> {
                log.info(bauser.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}
