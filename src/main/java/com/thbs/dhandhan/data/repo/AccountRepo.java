package com.thbs.dhandhan.data.repo;

import com.thbs.dhandhan.data.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Integer> {
}