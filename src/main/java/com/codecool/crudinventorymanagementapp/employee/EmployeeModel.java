package com.codecool.crudinventorymanagementapp.employee;

import com.codecool.crudinventorymanagementapp.inventory.InventoryModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class EmployeeModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnoreProperties("employee")
    private Set<InventoryModel> inventories = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<InventoryModel> getInventories() {
        return inventories;
    }

    public void setInventories(Set<InventoryModel> inventories) {
        this.inventories = inventories;
    }
}