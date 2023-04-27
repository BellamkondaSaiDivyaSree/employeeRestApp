package com.itelites.employeeRest.repositories;

import com.itelites.employeeRest.models.EmployeeData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Employeerepo extends MongoRepository<EmployeeData, String> {

}
