package com.job.portal.project.impservice;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.project.dto.EmployerApplicationsJobsDto;
import com.job.portal.project.dto.JobApplicationDto;
import com.job.portal.project.dto.JobResponse;
import com.job.portal.project.entity.Employee;
import com.job.portal.project.entity.Job;
import com.job.portal.project.entity.JobApplication;
import com.job.portal.project.repository.EmployeeRepository;
import com.job.portal.project.repository.JobApplicationRepository;
import com.job.portal.project.repository.JobRepository;
import com.job.portal.project.service.JobApplicationService;
@Service
public class JobApplicationImpService implements JobApplicationService {
	
	 private static final String APPLIED = "APPLIED";
	    private static final String CANCELED = "CANCELED";

	
@Autowired
    private JobApplicationRepository jobApplicationRepository;
@Autowired
    private EmployeeRepository employeeRepository;
@Autowired
    private JobRepository jobRepository;
@Autowired
    private ModelMapper modelMapper;

    @Override
    public String applyJob(int employeeId, int jobId) {

        Employee employee = checkEmployeeExistence(employeeId);

        Job job = checkJobExistence(jobId);


        JobApplication jobApplication = new JobApplication();

        jobApplication.setEmployee(employee);
        jobApplication.setJob(job);
        jobApplication.setAppliedDate(LocalDateTime.now());
        jobApplication.setStatus(APPLIED.toString());
        jobApplicationRepository.save(jobApplication);
        return "Job Applied Successfully";
    }

    @Override
    public List<JobApplicationDto> getAllApplicationsByEmployee(int employeeId) {

       Employee employee = checkEmployeeExistence(employeeId);

        List<JobApplication> jobApplications = jobApplicationRepository.findAllApplicationByEmployeeId(employeeId);

        List<JobApplicationDto> AllJobApplications = jobApplications.stream().map((jobApp) -> {
                    JobApplicationDto jobApplicationDto = new JobApplicationDto();
                    // Fill the data
                    jobApplicationDto.setApplicationId(jobApp.getId());
                    jobApplicationDto.setStatus(jobApp.getStatus());
                    jobApplicationDto.setAppliedDate(jobApp.getAppliedDate());
                    jobApplicationDto.setJobResponse(mapToJobDto(jobApp.getJob()));
                    return jobApplicationDto;
                }
        ).collect(Collectors.toList());
 return AllJobApplications;
    }
  @Override
    public String cancelApplication(int employeeId, int jobId, int applicationId) {

        Employee employee = checkEmployeeExistence(employeeId);

        Job job = checkJobExistence(jobId);

        JobApplication jobApplication = checkJobApplicationExistence(applicationId);

        jobApplication.setStatus(CANCELED.toString());

        jobApplicationRepository.save(jobApplication);

        return "Job Application Cancel Successfully";

    }

  @Override
  public List<EmployerApplicationsJobsDto> getAllApplicationsByEmployer(int employerId) {

      return jobApplicationRepository.findAllApplicationForEmployer(employerId)
              .stream()
              .map(application -> {

                  if (application.getCompanyLogo() != null) {
                      application.setCompanyLogo(
                          Paths.get(application.getCompanyLogo())
                               .getFileName()
                               .toString()
                      );
                  }

                  return application;
              })
              .collect(Collectors.toList());
  }

    @Override
    public String updateApplicationStatusByEmployer(int applicationId, String status) {

        JobApplication jobApplication = checkJobApplicationExistence(applicationId);

        if (jobApplication.getStatus().equals(CANCELED.toString())) {
           
        }

        jobApplication.setStatus(status);
        jobApplicationRepository.save(jobApplication);

        return "Application Status Changed Successfully";

    }

    @Override
    public  List<EmployerApplicationsJobsDto> getAllApplications() {

        return jobApplicationRepository.findAllApplication();

    }

    private JobResponse mapToJobDto(Job job) {

        JobResponse jobResponse = modelMapper.map(job, JobResponse.class);
        jobResponse.setCompanyLogo(Path.of(job.getLogoPath()).getFileName().toString());
        return jobResponse;
    }


    private Employee checkEmployeeExistence(int employeeId) {

        return employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                    new RuntimeException("Employee not found with id : " + employeeId)
                );
    }

    private Job checkJobExistence(int jobId) {

        return jobRepository.findById(jobId)
                .orElseThrow(() ->
                    new RuntimeException("Job not found with id : " + jobId)
                );
    }
    private JobApplication checkJobApplicationExistence(int applicationId) {

        JobApplication jobApplication = jobApplicationRepository.findById(applicationId).orElse(null) ;
        return jobApplication;
    }


}
