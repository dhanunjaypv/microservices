package com.sailotech.projects.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sailotech.projects.model.dto.ProjectDto;
import com.sailotech.projects.model.entity.Project;
import com.sailotech.projects.repo.ProjectRepo;
import com.sailotech.projects.service.ProjectService;
import com.sailotech.projects.util.ProjectUtil;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepo projectRepo;

	@Autowired
	ProjectUtil projectUtil;

	@Override
	public ProjectDto saveProjectInfo(ProjectDto projectDto) {
		Project project = projectUtil.mapToEntity(projectDto);
		project.setCreatedOn(LocalDateTime.now());
		Project projectResponse = projectRepo.save(project);

		return projectUtil.mapToDto(projectResponse);
	}

	@Override
	public ProjectDto getProjectInfo(String projectID) {
		Project projectResponse = projectRepo.findByProjectId(projectID);

		return projectUtil.mapToDto(projectResponse);

	}

}
