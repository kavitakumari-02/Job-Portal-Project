package com.job.portal.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.project.dto.EmployerApplicationsJobsDto;
import com.job.portal.project.service.JobApplicationService;

@RestController
@RequestMapping("/api/jobs/jobApplications")
//@Tag(name = "REST APIs for Job Application")
public class JobApplicationController {

@Autowired
    private JobApplicationService jobApplicationService;

    

    @GetMapping
    public ResponseEntity<List<EmployerApplicationsJobsDto>> getAllJobApplications() {

        return ResponseEntity.ok(jobApplicationService.getAllApplications());
    }
}
