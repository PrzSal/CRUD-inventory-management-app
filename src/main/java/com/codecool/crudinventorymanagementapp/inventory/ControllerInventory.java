package com.codecool.crudinventorymanagementapp.inventory;

import com.codecool.crudinventorymanagementapp.employee.EmployeeModel;
import com.codecool.crudinventorymanagementapp.employee.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/inventory/**")
public class ControllerInventory {

    private ServiceInventory serviceInventory;
    private ServiceEmployee serviceEmployee;
    @Autowired
    public ControllerInventory(ServiceInventory serviceInventory, ServiceEmployee serviceEmployee) {
        this.serviceInventory = serviceInventory;
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping(path = "")
    public ModelAndView index() {
        Map<String, Iterable> params = new HashMap<>();
        params.put("inventories", this.serviceInventory.findAllInventory());
        return new ModelAndView("inventory", params);
    }

    @GetMapping(path = "/inventory/add")
    public ModelAndView addInventory(Model model) {
        model.addAttribute("inventoryModel", new InventoryModel());
        return new ModelAndView("add_inventory");
    }

    @PostMapping(path = "/inventory/add")
    public ModelAndView createInventory(@ModelAttribute InventoryModel inventoryModel) {
        EmployeeModel employeeModel =  this.serviceEmployee.findOneEmployee(2);
        inventoryModel.setEmployeeModel(employeeModel);
        inventoryModel.setCode("del12");
        this.serviceInventory.createInventory(inventoryModel);
        Map<String, Iterable> params = new HashMap<>();
        params.put("inventories", this.serviceInventory.findAllInventory());
        return new ModelAndView("inventory", params);
    }
}