package com.sailotech.employee.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.DiscoveryClient;
import com.sailotech.employee.model.dto.EmployeeDto;
import com.sailotech.employee.model.dto.EmployeeServiceResponse;
import com.sailotech.employee.model.dto.ProjectServiceResponse;
import com.sailotech.employee.service.EmployeeService;
import com.sailotech.employee.service.ProjectServiceRestConsumer;
import com.sailotech.employee.util.EmployeeUtil;

@RestController
public class EmployeeCtrl {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeUtil employeeUtil;

	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	ProjectServiceRestConsumer projectServiceRestConsumer;
	
	


	@PostMapping("/emp/save")
	public EmployeeServiceResponse saveEmployeeInfo(@RequestBody EmployeeDto employeeDTO) {
		EmployeeDto employeeResponseDto = employeeService.saveEmployeeInfo(employeeDTO);
		
		return employeeUtil.prepareSuccessResponse(employeeResponseDto);

	}

	@GetMapping("/emp/get")
	public EmployeeServiceResponse getEmployeeInfo(@RequestParam Integer employeeId) {
		EmployeeDto employeeResponseDto = employeeService.getEmployeeInfo(employeeId);

		return employeeUtil.prepareSuccessResponse(employeeResponseDto);

	}

	@GetMapping("/emp/myproject")
	public ProjectServiceResponse getEmployeeProjectInfo(@RequestParam String projectID) {
		
		
		ProjectServiceResponse projectServiceResponse = employeeService.getProjectInformation(projectID);

		return projectServiceResponse;

	}

	
}
