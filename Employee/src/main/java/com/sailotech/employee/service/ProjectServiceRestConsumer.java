/**
 * 
 */
package com.sailotech.employee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sailotech.employee.model.dto.ProjectServiceResponse;

import io.github.resilience4j.retry.annotation.Retry;

/**
 * 
 */

@FeignClient(name = "sailotech-projects")
public interface ProjectServiceRestConsumer {

	

	@GetMapping("/project/get")
	//@HystrixCommand(fallbackMethod = "defaultResponse")
	public ProjectServiceResponse getProjectInformation(@RequestParam String projectID);



}
