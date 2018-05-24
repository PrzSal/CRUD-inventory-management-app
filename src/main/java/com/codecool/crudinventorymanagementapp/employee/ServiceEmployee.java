package com.codecool.crudinventorymanagementapp.employee;

public interface ServiceEmployee {
    Iterable<EmployeeModel> findAllEmployee();
    EmployeeModel findOneEmployee(Integer id);
    void createEmployee(EmployeeModel employeeModel);
    void deleteEmployee(Integer id);
    void updateEmployee(EmployeeModel employeeModel);
}
