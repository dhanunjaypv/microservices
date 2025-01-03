package com.sailotech.employee.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EmployeeDto {

	private Integer employeeId;

	private String name;
	private String address;
	private String email;
	private LocalDateTime createdOn;
	private String projectId;
}
