package com.thbs.dhandhan.data.repo;

import com.thbs.dhandhan.data.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    Customer findByCustomerId(String customerId);
}
