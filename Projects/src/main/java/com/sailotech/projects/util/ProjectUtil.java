package com.sailotech.projects.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sailotech.projects.model.dto.ProjectDto;
import com.sailotech.projects.model.dto.ProjectServiceResponse;
import com.sailotech.projects.model.entity.Project;

@Component
public class ProjectUtil {

	@Autowired
	ModelMapper modelMapper;

	public Project mapToEntity(ProjectDto projectDto) {
		Project project = modelMapper.map(projectDto, Project.class);
		System.out.println(project);
		return project;
	}

	public ProjectDto mapToDto(Project project) {
		ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);

		return projectDto;
	}

	public ProjectServiceResponse prepareSuccessResponse(ProjectDto projectResponseDto) {
	ProjectServiceResponse projectServiceResponse = new ProjectServiceResponse();
	projectServiceResponse.setCode("EMP-000");
	projectServiceResponse.setMessage("Successfully completed");
	projectServiceResponse.setStatus("SUCCESS");
	projectServiceResponse.setData(projectResponseDto);

		return projectServiceResponse;
	}

}
