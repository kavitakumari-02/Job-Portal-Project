package com.job.portal.project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.project.dto.EmployerApplicationsJobsDto;
import com.job.portal.project.dto.JobDto;
import com.job.portal.project.dto.JobResponse;
import com.job.portal.project.entity.Employer;
import com.job.portal.project.service.EmployerService;
import com.job.portal.project.service.JobApplicationService;
//import com.job.portal.project.service.JobService;
import com.job.portal.project.service.JobService;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	
	@Autowired
	private EmployerService employerService;
	@Autowired
    private JobService jobService;
	@Autowired
   private JobApplicationService jobApplicationService;

	 @PostMapping
	    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer) {

	        return new ResponseEntity<>(employerService.createEmployer(employer), HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<Employer>> getAllEmployers() {
	        return ResponseEntity.ok(employerService.findAllEmployers());
	    }
	    
	    // Employers Jobs Related Functions

	    @PostMapping(value = "/{employerId}/jobs", consumes = {"*/*"})
	    public ResponseEntity<String> createJob(@ModelAttribute JobDto jobDto,
	                                            @PathVariable("employerId") int employerId)
	            throws IOException {

	        return new ResponseEntity<>(jobService.createJob(jobDto, employerId), HttpStatus.CREATED);

	    }

	    @PostMapping("/{employerId}/myApplications/{applicationId}")
	    public ResponseEntity<String> updateJobApplicationsStatus(
	            @PathVariable("applicationId") int applicationId,
	            @RequestParam("status") String status) {

	        return new ResponseEntity<>(jobApplicationService.updateApplicationStatusByEmployer(applicationId, status), HttpStatus.CREATED);

	    }


	    @GetMapping(value = "/{employerId}/jobs")
	    public ResponseEntity<List<JobResponse>> getAllJobsByEmployer(@PathVariable("employerId") int employerId) {
	        return ResponseEntity.ok(jobService.findByAllJobsByEmployerId(employerId));
	    }


	    @GetMapping(value = "/{employerId}/myApplications")
	    public ResponseEntity<List<EmployerApplicationsJobsDto>> getAllApplicationByEmployerId(
	            @PathVariable("employerId") int employerId
	    ) {
	        return ResponseEntity.ok(jobApplicationService.getAllApplicationsByEmployer(employerId));
	    }


	    @DeleteMapping({"/{employerId}/jobs/{jobId}"})
	    public ResponseEntity<String> deleteJob(@PathVariable("employerId") int employerId,
	                                            @PathVariable("jobId") int jobId) {

	        return ResponseEntity.ok(jobService.deleteJob(employerId, jobId));

	    }


}
