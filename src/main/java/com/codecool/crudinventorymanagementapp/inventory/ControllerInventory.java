package com.codecool.crudinventorymanagementapp.inventory;

import com.codecool.crudinventorymanagementapp.employee.EmployeeModel;
import com.codecool.crudinventorymanagementapp.employee.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
        this.serviceInventory.createInventory(inventoryModel);
        Map<String, Iterable> params = new HashMap<>();
        params.put("inventories", this.serviceInventory.findAllInventory());
        return new ModelAndView("redirect:/inventory", params);
    }

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET)
    public ModelAndView editEmployee(@PathVariable String id, Model model) {
        Map<String, Iterable> params = new HashMap<>();
        ArrayList<InventoryModel> test = new ArrayList<>();
        test.add(this.serviceInventory.findOneInventory(Integer.valueOf(id)));
        model.addAttribute("inventoryModel", test.get(0));
        params.put("inventories", test);

        return new ModelAndView("edit_inventory", params);
    }

    @RequestMapping(value ="/inventory/{id}", method= RequestMethod.PUT)
    public ModelAndView update(@PathVariable String id, @ModelAttribute InventoryModel inventoryModel) {
        EmployeeModel employeeModel =  this.serviceEmployee.findOneEmployee(2);
        inventoryModel.setEmployeeModel(employeeModel);
        inventoryModel.setId(Integer.valueOf(id));
        this.serviceInventory.updateInventory(inventoryModel);
        Map<String, Iterable> params = new HashMap<>();
        params.put("inventories", this.serviceInventory.findAllInventory());
        return new ModelAndView("redirect:/inventory", params);
    }

    @RequestMapping(value ="/inventory/delete/{id}", method= RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable String id) {
        this.serviceInventory.deleteInventory(Integer.valueOf(id));
        Map<String, Iterable> params = new HashMap<>();
        params.put("inventories", this.serviceInventory.findAllInventory());
        return new ModelAndView("redirect:/inventory", params);
    }
}