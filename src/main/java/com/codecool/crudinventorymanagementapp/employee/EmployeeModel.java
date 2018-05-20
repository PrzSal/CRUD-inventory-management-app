package com.codecool.crudinventorymanagementapp.employee;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    private String email;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String regionResponsibility;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegionResponsibility() {
        return regionResponsibility;
    }

    public void setRegionResponsibility(String regionResponsibility) {
        this.regionResponsibility = regionResponsibility;
    }
}