package com.sailotech.projects.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "projects")
@Entity
@Data
public class Project
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid")
	private Integer pid;
	@Column(name="project_id")
	private String projectId;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="created_on")
	private LocalDateTime createdOn;

}
