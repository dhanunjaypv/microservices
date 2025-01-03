package com.sailotech.projects.service;

import org.springframework.stereotype.Service;

import com.sailotech.projects.model.dto.ProjectDto;

@Service
public interface ProjectService {

ProjectDto saveProjectInfo(ProjectDto projectDto);

ProjectDto getProjectInfo(String projectID);

}
