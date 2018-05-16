package com.codecool.crudinventorymanagementapp.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryInventory extends CrudRepository<InventoryModel, Integer> {
}