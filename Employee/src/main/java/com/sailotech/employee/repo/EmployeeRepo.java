package com.sailotech.employee.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sailotech.employee.model.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	Employee findByEmployeeId(Integer employeeId);

}
