package com.itelites.employeeRest.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employee")
public class EmployeeData
{
    @Id
    String id;
    String name;
    String address;
    String department;
    public EmployeeData(){}
    public EmployeeData(String id, String name, String address, String department){
        this.id=id;
        this.name=name;
        this.address=address;
        this.department=department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
