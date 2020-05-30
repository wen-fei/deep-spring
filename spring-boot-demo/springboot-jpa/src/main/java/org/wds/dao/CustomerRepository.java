package org.wds.dao;

import org.springframework.data.repository.CrudRepository;
import org.wds.entity.Customer;

import java.util.List;

/**
 * @author : TenYun
 * @date : 2020-05-30 22:41
 * @description : 与数据库交互
 **/
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);

}
