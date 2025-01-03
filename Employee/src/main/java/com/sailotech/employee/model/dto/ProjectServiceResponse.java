package com.sailotech.employee.model.dto;

import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
@Nonnull
public class ProjectServiceResponse {
	
	private String status;
	private String code;
	private String message;
	private Object data;
	

}
