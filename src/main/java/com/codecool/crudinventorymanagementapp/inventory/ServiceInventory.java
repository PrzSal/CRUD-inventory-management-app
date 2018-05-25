package com.codecool.crudinventorymanagementapp.inventory;

public interface ServiceInventory {

    Iterable<InventoryModel> findAllInventoryForUser();
    InventoryModel findOneInventory(Integer id);
    void createInventory(InventoryModel inventoryModel);
    void deleteInventory(Integer id);
    void updateInventory(InventoryModel inventoryModel);
}