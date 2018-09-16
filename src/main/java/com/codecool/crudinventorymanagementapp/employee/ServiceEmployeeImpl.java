package com.codecool.crudinventorymanagementapp.employee;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

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
    public EmployeeModel findOneEmployee(Long id) {
        return this.repositoryEmployee.findOne(id);
    }

    @Override
    public void createEmployee(EmployeeModel employeeModel) {
        employeeModel.setLogin(createLogin(employeeModel));
        employeeModel.setPassword(createPassword(employeeModel));
        this.repositoryEmployee.save(employeeModel);
    }

    @Override
    public void deleteEmployee(Long id) {
        this.repositoryEmployee.delete(id);
    }

    @Override
    public void updateEmployee(EmployeeModel employeeModel) {
        employeeModel.setLogin(createLogin(employeeModel));
        employeeModel.setPassword(createPassword(employeeModel));
        if (employeeModel.getId().longValue() != 0 && repositoryEmployee.findOne(employeeModel.getId()) != null) {
            System.out.println( );
            try {
                repositoryEmployee.save(employeeModel);
            } catch (RuntimeException e) {
                System.out.println("exce");
            }
        }
    }

    private String createLogin(EmployeeModel employeeModel) {
        String firstThreeName = employeeModel.getName().substring(0, 3);
        String firstThreeSurname = employeeModel.getSurname().substring(0, 3);
        String newLogin = firstThreeName + firstThreeSurname;
        return newLogin;
    }

    private String createPassword(EmployeeModel employeeModel) {
        String newPassword = employeeModel.getLogin();
        return newPassword;
    }
}
