package com.codecool.crudinventorymanagementapp.inventory;

public interface ServiceInventory {

    Iterable<InventoryModel> findAllInventoryForUser();
    InventoryModel findOneInventory(Long id);
    void createInventory(InventoryModel inventoryModel);
    void deleteInventory(Long id);
    void updateInventory(InventoryModel inventoryModel);
}