package com.job.portal.project.impservice;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.job.portal.project.dto.JobDto;
import com.job.portal.project.dto.JobResponse;
import com.job.portal.project.entity.Employer;
import com.job.portal.project.entity.Job;
import com.job.portal.project.entity.JobCategory;
import com.job.portal.project.repository.EmployerRepository;
import com.job.portal.project.repository.JobCategoryRepository;
import com.job.portal.project.repository.JobRepository;
import com.job.portal.project.service.JobService;
import com.job.portal.project.utils.AppConstant;
import com.job.portal.project.utils.SaveToDisk;
@Service
public class JobImpService implements JobService{
	@Autowired
	private JobRepository jobRepository;
	@Autowired
    private ModelMapper modelMapper;
	@Autowired
    private EmployerRepository employerRepository;
	@Autowired
    private JobCategoryRepository jobCategoryRepository;
    @Override
    public String createJob(JobDto jobDto, int employerId) throws IOException {

        Employer employer = checkEmployerExist(employerId);
        JobCategory jobCategory = checkJobCategoryExist(jobDto.getJobCategory());


        MultipartFile companyLogo = jobDto.getCompanyLogo();

        Path fullPath = Paths.get(AppConstant.PathToSaveLogo + companyLogo.getOriginalFilename());

        SaveToDisk.saveFile(companyLogo, fullPath);
        
        Job job = mapToJob(jobDto);
        job.setLogoPath(fullPath.toString());
        job.setEmployer(employer);
        job.setJobCategory(jobCategory);

        Job savedJob = jobRepository.save(job);

        return "Job Created Successfully";
    }
    
    @Override
    public List<JobResponse> findByAllJobsByEmployerId(int id) {
//    	List<Job>jobes=jobRepository.test(7);
//        System.out.println("size of test"+jobs.size());
        //     checkEmployerExist(employerId);
    	List<JobResponse> jobs = jobRepository.findByAllJobsByEmployerId(id);
    	System.out.println("size"+jobs.size());
        return jobs.stream().map((job) -> {


            String fullPath = job.getCompanyLogo();

            Path path = Paths.get(fullPath);

            job.setCompanyLogo(path.getFileName().toString());
            return job;
        }).collect(Collectors.toList());
    }

    @Override
    public List<JobResponse> getAllJobs() {

        return jobRepository.findByAllJobs();
    }

    @Override
    public String deleteJob(int employerId, int jobId) {

        checkEmployerExist(employerId);
        Job job = checkJobExist(jobId);
        job.setEmployer(null);
        job.setJobCategory(null);
        jobRepository.delete(job);
        return "Job Deleted Successfully";
    }

    @Override
    public JobResponse getJobByJobId(int jobId) {

        Job job = jobRepository.findById(jobId).orElseThrow();

        return mapToJobDto(job);
    }

    @Override
    public List<JobResponse> searchJob(String jobCategory, String jobType, String country) {


        return jobRepository.searchJobs(jobCategory, jobType, country);
    }


    private Employer checkEmployerExist(int employerId) {

        Employer employer = employerRepository.findById(employerId).orElse(null);
        return employer;
    }

    private JobCategory checkJobCategoryExist(String title) {
        JobCategory jobCategory = jobCategoryRepository.findByTitle(title).orElse(null);

        return jobCategory;
    }


    private Job checkJobExist(int jobId) {

        return jobRepository.findById(jobId).orElse(null);

    }


    private Job mapToJob(JobDto jobDto) {
        Job job = modelMapper.map(jobDto, Job.class);
        job.setId(0);
        return job;
    }

    private JobResponse mapToJobDto(Job job) {

        JobResponse jobResponse = modelMapper.map(job, JobResponse.class);
        jobResponse.setCompanyLogo(Path.of(job.getLogoPath()).getFileName().toString());
        return jobResponse;
    }


}
