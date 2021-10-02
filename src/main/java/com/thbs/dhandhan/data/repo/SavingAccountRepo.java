package com.thbs.dhandhan.data.repo;

import com.thbs.dhandhan.data.entity.SavingAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface SavingAccountRepo extends CrudRepository<SavingAccount, Integer> {
}
