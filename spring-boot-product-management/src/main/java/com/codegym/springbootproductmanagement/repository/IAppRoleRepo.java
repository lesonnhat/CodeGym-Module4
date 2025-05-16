package com.codegym.springbootproductmanagement.repository;

import com.codegym.springbootproductmanagement.model.security.AppRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppRoleRepo extends CrudRepository<AppRole, Long> {
    AppRole findByName(String name);
}
