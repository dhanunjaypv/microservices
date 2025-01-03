package com.sailotech.employee.model.dto;

import lombok.Data;

@Data
public class EmployeeServiceResponse {
	
	private String status;
	private String code;
	private String message;
	private Object data;
	

}
