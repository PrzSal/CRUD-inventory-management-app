package com.codecool.crudinventorymanagementapp.inventory;

import com.codecool.crudinventorymanagementapp.employee.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyQuery extends JpaRepository<EmployeeModel,Long> {

    public EmployeeModel findAllByLogin(String login);

}