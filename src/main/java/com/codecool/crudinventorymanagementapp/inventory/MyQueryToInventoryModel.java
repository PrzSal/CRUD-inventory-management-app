package com.codecool.crudinventorymanagementapp.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyQueryToInventoryModel extends JpaRepository<InventoryModel,Long> {
    public Iterable<InventoryModel> findAllByEmployeeModelId(Long employeeModelId);
}