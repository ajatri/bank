package com.thbs.dhandhan.data.repo;

import com.thbs.dhandhan.data.entity.TermedAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface TermedAccountRepo extends CrudRepository<TermedAccount, Integer> {
}
