package com.codecool.crudinventorymanagementapp.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/inventory")
public class ControllerInventory {

    private ServiceInventory serviceInventory;

    @Autowired
    public ControllerInventory(ServiceInventory serviceInventory) {
        this.serviceInventory = serviceInventory;
    }

    @GetMapping(path = "")
    public ModelAndView index() {
        Map<String, Iterable> params = new HashMap<>();
        params.put("inventories", this.serviceInventory.findAllInventory());
        return new ModelAndView("inventory", params);
    }

    @PostMapping(path = "")
    public InventoryModel create(@RequestBody InventoryModel inventoryModel) {
        this.serviceInventory.createInventory(inventoryModel);
        return inventoryModel;
    }
}