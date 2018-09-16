package com.codecool.crudinventorymanagementapp.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInventory extends CrudRepository<InventoryModel, Long> {
}
