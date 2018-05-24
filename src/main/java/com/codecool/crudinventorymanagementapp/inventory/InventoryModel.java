package com.codecool.crudinventorymanagementapp.inventory;

import com.codecool.crudinventorymanagementapp.employee.EmployeeModel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class InventoryModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String nameProduct;

    @NotEmpty
    private String description;

    @NotEmpty
    private String manufacture;

    @NotEmpty
    private String category;

    @NotEmpty
    private String code;

    @NotNull
    private int initialValue;

    @NotEmpty
    private String buyingDate;

    @NotEmpty
    private String status;

    @OneToOne(cascade = CascadeType.PERSIST)
    private EmployeeModel employeeModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String name) {
        this.nameProduct = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(int initialValue) {
        this.initialValue = initialValue;
    }

    public String getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(String buyingDate) {
        this.buyingDate = buyingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel owner) {
        this.employeeModel = owner;
    }
}
