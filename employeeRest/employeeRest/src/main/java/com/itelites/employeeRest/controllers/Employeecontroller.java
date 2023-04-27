package com.itelites.employeeRest.controllers;

import com.itelites.employeeRest.exceptionHandlers.exception;
import com.itelites.employeeRest.models.EmployeeData;
import com.itelites.employeeRest.repositories.Employeerepo;
import com.itelites.employeeRest.services.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/employees")
public class Employeecontroller {
    Logger logger = LoggerFactory.getLogger(Employeecontroller.class);
    @Autowired
    private RestTemplate restTemplate;
   @Autowired
   private Employeerepo repo;
   @Autowired
   private EmployeeService service;
   private static final String employeeController="EmployeeController";
    @PostMapping("/createData")
    public EmployeeData addData(@RequestBody EmployeeData employee){
        logger.info("create data end point accessed");
        return service.addData(employee);
    }

    @PutMapping("/update/{empId}")

    public EmployeeData updateData(@PathVariable String empId, @RequestBody EmployeeData employee){
        return service.updateData(empId, employee);
    }

    @GetMapping("/fetchEmployee/{empId}")
    public EmployeeData fetchEmployee(@PathVariable String empId){
//        EmployeeData employee = repo.findById(empId).orElseThrow(()->new exception("employee with ID -> " + empId + " not found,fetching failed"));
//        return (employee);
        return service.fetchEmployee(empId);
    }
    @GetMapping("/filterEmployeesByDep/{department}")
    public List<EmployeeData> employeesByDepartment(@PathVariable String department){
        return service.employeesByDepartment(department);
    }
    @GetMapping("/findAll")
    //@CircuitBreaker(name=employeeController, fallbackMethod = "getEmpoyeeFallback")
        public List<EmployeeData> employees(){
       logger.info("find all data end point accessed");
        return service.employees();}
//        public List<EmployeeData> getEmployeeFallback(Exception e){
//            List a = new ArrayList();
//            a.add(new EmployeeData("none","none","none","none"));
//            return a;
//        }
//
   }






