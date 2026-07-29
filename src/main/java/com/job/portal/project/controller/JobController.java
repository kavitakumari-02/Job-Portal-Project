package com.job.portal.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.project.dto.JobResponse;
import com.job.portal.project.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
     @Autowired
    private JobService jobService;

   


    @GetMapping("/{jobId}")
    public ResponseEntity<JobResponse> getJobByJobId(@PathVariable("jobId") int jobId) {

        return ResponseEntity.ok(jobService.getJobByJobId(jobId));
    }


    @GetMapping
    public ResponseEntity<List<JobResponse>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }


    @GetMapping("/search")
    public ResponseEntity<List<JobResponse>> searchJobs(@RequestParam(value = "jobCategory", required = false, defaultValue = "0000000") String jobCategory,
                                                        @RequestParam(value = "jobType", required = false, defaultValue = "000000000") String jobType,
                                                        @RequestParam(value = "country", required = false, defaultValue = "000000000") String country


    ) {

        return ResponseEntity.ok(jobService.searchJob(jobCategory, jobType,country));

    }

}
