package com.codecool.crudinventorymanagementapp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ModelAndView editEmployee(@PathVariable String id, Model model) {
        Map<String, Iterable> params = new HashMap<>();
        ArrayList<EmployeeModel> test = new ArrayList<>();
        test.add(this.serviceEmployee.findOneEmployee(Integer.valueOf(id)));
        model.addAttribute("employeeModel", test.get(0));
        params.put("employees", test);

        return new ModelAndView("edit_employee", params);
    }

    @PostMapping(path = "/employee/add")
    public ModelAndView create(@ModelAttribute EmployeeModel employeeModel) {
        employeeModel.setEnabled(true);
        this.serviceEmployee.createEmployee(employeeModel);
        Map<String, Iterable> params = new HashMap<>();
        params.put("employees", this.serviceEmployee.findAllEmployee());
        return new ModelAndView("employee", params);
    }

    @RequestMapping(value ="/employee/{id}", method= RequestMethod.PUT)
    public ModelAndView update(@PathVariable String id, @ModelAttribute EmployeeModel employeeModel) {
        employeeModel.setId(Integer.valueOf(id));
        employeeModel.setEnabled(true);
        this.serviceEmployee.updateEmployee(employeeModel);
        Map<String, Iterable> params = new HashMap<>();
        params.put("employees", this.serviceEmployee.findAllEmployee());
        return new ModelAndView("employee", params);
    }
}