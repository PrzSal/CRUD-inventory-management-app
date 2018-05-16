package com.codecool.crudinventorymanagementapp.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/inventory")
public class ControllerInventory {

    private ServiceInventory serviceInventory;

    @Autowired
    public ControllerInventory(ServiceInventory serviceInventory) {
        this.serviceInventory = serviceInventory;
    }

    @GetMapping(path = "")
    public Iterable<InventoryModel> index() {
        return this.serviceInventory.findAllInventory();
    }

    @PostMapping(path = "")
    public InventoryModel create(@RequestBody InventoryModel inventoryModel) {
        this.serviceInventory.createInventory(inventoryModel);
        return inventoryModel;
    }
}