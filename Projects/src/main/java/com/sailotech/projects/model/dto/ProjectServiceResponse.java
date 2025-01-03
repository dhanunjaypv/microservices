package com.sailotech.projects.model.dto;

import lombok.Data;

@Data
public class ProjectServiceResponse {
	
	private String status;
	private String code;
	private String message;
	private Object data;
	

}
