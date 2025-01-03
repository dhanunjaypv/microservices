package com.sailotech.projects.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sailotech.projects.model.dto.ProjectDto;
import com.sailotech.projects.model.dto.ProjectServiceResponse;
import com.sailotech.projects.service.ProjectService;
import com.sailotech.projects.util.ProjectUtil;

@RestController
public class ProjectCtrl {

	@Autowired
	ProjectService projectService;

	@Autowired
	ProjectUtil projectUtil;
	@Value("${server.port}")
	private int port;
	@Value("${eureka.instance.instance-id}")
	private String instanceId;

	@PostMapping("/project/save")
	public ProjectServiceResponse saveProjectInfo(@RequestBody ProjectDto projectDto) {
		ProjectDto projectResponseDto = projectService.saveProjectInfo(projectDto);

		return projectUtil.prepareSuccessResponse(projectResponseDto);

	}
	
	@GetMapping("/project/get")
	public ProjectServiceResponse getProjectInfo(@RequestParam String projectID) {
		
		System.out.println("**************** PORT# "+port+" ************************* INSTANCE ID # "+instanceId);
		ProjectDto projectResponseDto = projectService.getProjectInfo(projectID);

		return projectUtil.prepareSuccessResponse(projectResponseDto);

	}

}
