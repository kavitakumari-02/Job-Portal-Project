package com.job.portal.project.service;

import java.util.List;

import com.job.portal.project.dto.EmployerApplicationsJobsDto;
import com.job.portal.project.dto.JobApplicationDto;

public interface JobApplicationService {

	String  applyJob(int employeeId, int jobId);
    List<JobApplicationDto> getAllApplicationsByEmployee(int employeeId);


    String cancelApplication(int employeeId, int jobId ,int applicationId);

    List<EmployerApplicationsJobsDto> getAllApplicationsByEmployer(int employerId);

    String updateApplicationStatusByEmployer(int applicationId,String status);

    List<EmployerApplicationsJobsDto> getAllApplications();
}
