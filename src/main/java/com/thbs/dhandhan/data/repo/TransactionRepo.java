package com.thbs.dhandhan.data.repo;

import com.thbs.dhandhan.data.entity.Customer;
import com.thbs.dhandhan.data.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepo extends CrudRepository<Transaction, Integer> {



}