package com.sailotech.projects.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProjectDto {

	private Integer pid;

	private String projectId;
	private String name;
	private String description;
	private LocalDateTime createdOn;
}
