package com.codecool.crudinventorymanagementapp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class ControllerEmployee {

    private ServiceEmployee serviceEmployee;

    @Autowired
    public ControllerEmployee(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping(path = "")
    public Iterable<EmployeeModel> index() {
        return this.serviceEmployee.findAllEmployee();
    }

    @PostMapping(path = "")
    public EmployeeModel create(@RequestBody EmployeeModel employeeModel) {
        this.serviceEmployee.createEmployee(employeeModel);
        return employeeModel;
    }
}