package com.codecool.crudinventorymanagementapp.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmployee extends CrudRepository<EmployeeModel, Integer> {
}