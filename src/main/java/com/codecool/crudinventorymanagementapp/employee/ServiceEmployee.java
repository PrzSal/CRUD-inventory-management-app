package com.codecool.crudinventorymanagementapp.employee;

public interface ServiceEmployee {
    Iterable<EmployeeModel> findAllEmployee();
    EmployeeModel findOneEmployee(Long id);
    void createEmployee(EmployeeModel employeeModel);
    void deleteEmployee(Long id);
    void updateEmployee(EmployeeModel employeeModel);
}
