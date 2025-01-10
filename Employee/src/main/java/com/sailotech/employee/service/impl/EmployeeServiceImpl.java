package com.sailotech.employee.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailotech.employee.model.dto.EmployeeDto;
import com.sailotech.employee.model.dto.ProjectServiceResponse;
import com.sailotech.employee.model.entity.Employee;
import com.sailotech.employee.repo.EmployeeRepo;
import com.sailotech.employee.service.EmployeeService;
import com.sailotech.employee.service.ProjectServiceRestConsumer;
import com.sailotech.employee.util.EmployeeUtil;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	EmployeeUtil employeeUtil;

	@Autowired
	ProjectServiceRestConsumer projectServiceRestConsumer;

	@Override
	public EmployeeDto saveEmployeeInfo(EmployeeDto employeeDto) {
		Employee employee = employeeUtil.mapToEntity(employeeDto);
		employee.setCreatedOn(LocalDateTime.now());
		Employee employeeResponse = employeeRepo.save(employee);

		return employeeUtil.mapToDto(employeeResponse);
	}

	@Override
	public EmployeeDto getEmployeeInfo(Integer employeeId) {
		// TODO Auto-generated method stub
		Employee employeeResponse = employeeRepo.findByEmployeeId(employeeId);

		return employeeUtil.mapToDto(employeeResponse);
	}

	@Override
	@CircuitBreaker(name = "userService", fallbackMethod = "getInfo")
	public ProjectServiceResponse getProjectInformation(String projectID) {
		
		return projectServiceRestConsumer.getProjectInformation(projectID);

	}

	public ProjectServiceResponse getInfo(String projectID, Throwable throwable) {
		System.out.println("FALBACK****************************************************************");
		ProjectServiceResponse projectServiceResponse = new ProjectServiceResponse();
		projectServiceResponse.setStatus("FAIL");
		return projectServiceResponse;

	}

	@Override
	public List<EmployeeDto> getAllEmployeesInfo() {
		List<Employee> employeeResponseList = employeeRepo.findAll();
		return employeeUtil.mapToDtoList(employeeResponseList);
	}

}
