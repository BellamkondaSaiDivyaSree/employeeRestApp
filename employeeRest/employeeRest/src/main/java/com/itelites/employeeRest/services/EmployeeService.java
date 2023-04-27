package com.itelites.employeeRest.services;

import com.itelites.employeeRest.exceptionHandlers.exception;
import com.itelites.employeeRest.models.EmployeeData;
import com.itelites.employeeRest.repositories.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeService {
    @Autowired
    private Employeerepo repo;
    public EmployeeData addData(@RequestBody EmployeeData employee){

        return repo.save(employee);
    }
    public EmployeeData updateData(@PathVariable String empId, @RequestBody EmployeeData employee){
        EmployeeData existingData = repo.findById(empId).orElseThrow(()->new exception("employee with ID -> " + empId + " not found,update failed"));
        employee.setName(employee.getName());
        employee.setAddress(employee.getAddress());
        employee.setDepartment(employee.getDepartment());
        return repo.save(employee);
    }
    public EmployeeData fetchEmployee(@PathVariable String empId){
        EmployeeData employee = repo.findById(empId).orElseThrow(()->new exception("employee with ID -> " + empId + " not found,fetching failed"));
        return (employee);
    }
    public List<EmployeeData> employeesByDepartment(@PathVariable String department){
        return repo.findAll().stream().filter(x -> x.getDepartment().contains(department)).collect(Collectors.toList());
    }
    public List<EmployeeData> employees(){

        return repo.findAll();

    }
}
