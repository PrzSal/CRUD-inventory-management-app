package com.codecool.crudinventorymanagementapp.inventory;

import org.springframework.stereotype.Service;

@Service
public class ServiceInventoryImpl implements ServiceInventory {

    private RepositoryInventory repositoryInventory;

    public ServiceInventoryImpl(RepositoryInventory repositoryInventory) {
        this.repositoryInventory = repositoryInventory;
    }

    @Override
    public Iterable<InventoryModel> findAllInventory() {
        return this.repositoryInventory.findAll();
    }

//    @Override
//    public InventoryModel findOneInventory(Integer id) {
//        return this.repositoryInventory.findById(id);
//    }

    @Override
    public void createInventory(InventoryModel inventoryModel) {
        this.repositoryInventory.save(inventoryModel);
    }

    @Override
    public void deleteInventory(Integer id) {
        this.repositoryInventory.deleteById(id);
    }

    @Override
    public void updateInventory(InventoryModel inventoryModel) {
        this.repositoryInventory.save(inventoryModel);
    }
}
