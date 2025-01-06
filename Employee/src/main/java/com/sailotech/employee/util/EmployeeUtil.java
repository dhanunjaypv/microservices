package com.sailotech.employee.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sailotech.employee.model.dto.EmployeeDto;
import com.sailotech.employee.model.dto.EmployeeServiceResponse;
import com.sailotech.employee.model.entity.Employee;

@Component
public class EmployeeUtil {

	@Autowired
	ModelMapper modelMapper;

	public Employee mapToEntity(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		System.out.println(employee);
		return employee;
	}

	public EmployeeDto mapToDto(Employee employee) {
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

		return employeeDto;
	}

	public EmployeeServiceResponse prepareSuccessResponse(Object employeeResponseDto) {
		EmployeeServiceResponse employeeServiceResponse = new EmployeeServiceResponse();
		employeeServiceResponse.setCode("EMP-000");
		employeeServiceResponse.setMessage("Successfully completed");
		employeeServiceResponse.setStatus("SUCCESS");
		employeeServiceResponse.setData(employeeResponseDto);

		return employeeServiceResponse;
	}

	public List<EmployeeDto> mapToDtoList(List<Employee> employeeResponseList) {
		List<EmployeeDto> dtos = employeeResponseList
				  .stream()
				  .map(user -> modelMapper.map(user, EmployeeDto.class))
				  .collect(Collectors.toList());
		return dtos;
	}

}
