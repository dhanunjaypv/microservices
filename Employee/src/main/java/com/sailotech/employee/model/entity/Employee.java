package com.sailotech.employee.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "employee")
@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Integer employeeId;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="email")
	private String email;
	@Column(name="created_on")
	private LocalDateTime createdOn;
	@Column(name="project_id")
	private String projectId;

}
