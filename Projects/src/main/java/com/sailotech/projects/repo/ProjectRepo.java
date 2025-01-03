package com.sailotech.projects.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sailotech.projects.model.entity.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer>{

	Project findByProjectId(String projectID);

}
