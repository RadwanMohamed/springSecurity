package com.coder.springsecuritydemo.repository;

import com.coder.springsecuritydemo.model.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {
    CustomerEntity findByEmail(String email);
}
