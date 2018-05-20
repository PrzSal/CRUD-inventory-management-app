package com.codecool.crudinventorymanagementapp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/employee/**")
public class ControllerEmployee {

    private ServiceEmployee serviceEmployee;

    @Autowired
    public ControllerEmployee(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping(path = "")
    public ModelAndView index() {
        Map<String, Iterable> params = new HashMap<>();
        params.put("employees", this.serviceEmployee.findAllEmployee());
        return new ModelAndView("employee", params);
    }

    @GetMapping(path = "/employee/add")
    public ModelAndView addEmployee(Model model) {
        model.addAttribute("employeeModel", new EmployeeModel());
        return new ModelAndView("add_employee");
    }

    @PostMapping(path = "")
    public ModelAndView create(@ModelAttribute EmployeeModel employeeModel) {
        this.serviceEmployee.createEmployee(employeeModel);
        Map<String, Iterable> params = new HashMap<>();
        params.put("employees", this.serviceEmployee.findAllEmployee());
        return new ModelAndView("employee", params);
    }
}