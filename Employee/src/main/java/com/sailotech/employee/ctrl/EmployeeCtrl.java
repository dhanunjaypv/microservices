package com.sailotech.employee.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sailotech.employee.model.dto.EmployeeDto;
import com.sailotech.employee.model.dto.EmployeeServiceResponse;
import com.sailotech.employee.model.dto.ProjectServiceResponse;
import com.sailotech.employee.service.EmployeeService;
import com.sailotech.employee.service.ProjectServiceRestConsumer;
import com.sailotech.employee.util.EmployeeUtil;

@RestController
@RequestMapping("/employee")
public class EmployeeCtrl {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeUtil employeeUtil;


	@Autowired
	ProjectServiceRestConsumer projectServiceRestConsumer;
	
	


	@PostMapping("/save")
	public EmployeeServiceResponse saveEmployeeInfo(@RequestBody EmployeeDto employeeDTO) {
		EmployeeDto employeeResponseDto = employeeService.saveEmployeeInfo(employeeDTO);
		
		return employeeUtil.prepareSuccessResponse(employeeResponseDto);

	}

	@GetMapping("/getById")
	public EmployeeServiceResponse getEmployeeInfo(@RequestParam Integer employeeId) {
		EmployeeDto employeeResponseDto = employeeService.getEmployeeInfo(employeeId);

		return employeeUtil.prepareSuccessResponse(employeeResponseDto);

	}

	@GetMapping("/myproject")
	public ProjectServiceResponse getEmployeeProjectInfo(@RequestParam String projectID) {
		
		
		ProjectServiceResponse projectServiceResponse = employeeService.getProjectInformation(projectID);

		return projectServiceResponse;

	}
	
	@GetMapping("/getAll")
	public EmployeeServiceResponse getAllEmployeesInfo() {
		List<EmployeeDto> employeeResponseDto = employeeService.getAllEmployeesInfo();

		return employeeUtil.prepareSuccessResponse(employeeResponseDto);

	}


	
}
