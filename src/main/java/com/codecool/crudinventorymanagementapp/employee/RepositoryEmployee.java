package com.codecool.crudinventorymanagementapp.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RepositoryEmployee extends CrudRepository<EmployeeModel, Long> {
}