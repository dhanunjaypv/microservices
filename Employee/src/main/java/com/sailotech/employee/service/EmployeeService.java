package com.sailotech.employee.service;

import org.springframework.stereotype.Service;

import com.sailotech.employee.model.dto.EmployeeDto;
import com.sailotech.employee.model.dto.ProjectServiceResponse;

@Service
public interface EmployeeService {

	EmployeeDto saveEmployeeInfo(EmployeeDto employeeDto);

	EmployeeDto getEmployeeInfo(Integer employeeId);

	ProjectServiceResponse getProjectInformation(String projectID);
	
	

}
