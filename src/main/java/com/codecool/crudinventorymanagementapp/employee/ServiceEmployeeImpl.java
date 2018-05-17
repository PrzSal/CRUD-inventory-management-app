package com.codecool.crudinventorymanagementapp.employee;

import org.springframework.stereotype.Service;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {
    private RepositoryEmployee repositoryEmployee;

    public ServiceEmployeeImpl(RepositoryEmployee repositoryEmployee) {
        this.repositoryEmployee = repositoryEmployee;
    }

    @Override
    public Iterable<EmployeeModel> findAllEmployee() {
        return this.repositoryEmployee.findAll();
    }

    @Override
    public EmployeeModel findOneEmployee(Integer id) {
        return this.repositoryEmployee.findOne(id);
    }

    @Override
    public void createEmployee(EmployeeModel employeeModel) {
        this.repositoryEmployee.save(employeeModel);
    }

    @Override
    public void deleteEmployee(Integer id) {
        this.repositoryEmployee.delete(id);
    }

    @Override
    public void updateEmployee(EmployeeModel employeeModel) {
        this.repositoryEmployee.save(employeeModel);
    }
}
