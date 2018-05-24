package com.codecool.crudinventorymanagementapp.inventory;

import com.codecool.crudinventorymanagementapp.employee.EmployeeModel;
import com.codecool.crudinventorymanagementapp.employee.ServiceEmployee;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class ServiceInventoryImpl implements ServiceInventory {

    private RepositoryInventory repositoryInventory;
    private ServiceEmployee serviceEmployee;
    private Random randomGenerator;

    public ServiceInventoryImpl(RepositoryInventory repositoryInventory, ServiceEmployee serviceEmployee) {
        this.repositoryInventory = repositoryInventory;
        this.serviceEmployee = serviceEmployee;
    }

    @Override
    public Iterable<InventoryModel> findAllInventory() {
        return this.repositoryInventory.findAll();
    }

    @Override
    public InventoryModel findOneInventory(Integer id) {
        return this.repositoryInventory.findOne(id);
    }

    @Override
    public void createInventory(InventoryModel inventoryModel) {

        inventoryModel.setCode(this.createCode(inventoryModel));
        this.repositoryInventory.save(inventoryModel);
    }

    @Override
    public void deleteInventory(Integer id) {
        this.repositoryInventory.delete(id);
    }

    @Override
    public void updateInventory(InventoryModel inventoryModel) {
        this.repositoryInventory.save(inventoryModel);
    }

    private String createCode(InventoryModel inventoryModel) {
        String code = inventoryModel.getNameProduct() + inventoryModel.getDescription();
        Integer hashCode = code.hashCode();
        code =  String.valueOf(inventoryModel.getId()) + String.valueOf(hashCode);
        return code;
    }

    private EmployeeModel assignedEmployee(InventoryModel inventoryModel) {
        ArrayList<EmployeeModel> employees = (ArrayList<EmployeeModel>) serviceEmployee.findAllEmployee();
        ArrayList<EmployeeModel> employeesResponsible = new ArrayList<>();
        EmployeeModel employeeModel;
        for (EmployeeModel employee : employees) {
            if (employee.getRegionResponsibility().equals(inventoryModel.getPlaceResidence())) {
                employeesResponsible.add(employee);
            }
        }

        if (employeesResponsible.size() > 0) {
            int index = randomGenerator.nextInt(employeesResponsible.size());
            employeeModel = employeesResponsible.get(index);
        } else {
            int index = randomGenerator.nextInt(employees.size());
            employeeModel = employees.get(index);
        }
        return employeeModel;
    }
}
