package com.thbs.dhandhan.data.repo;

import com.thbs.dhandhan.data.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface AdminRepo extends CrudRepository<Admin, Integer> {
}
