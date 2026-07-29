package com.job.portal.project.impservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.project.entity.JobCategory;
import com.job.portal.project.repository.JobCategoryRepository;
import com.job.portal.project.service.JobCategoryService;
@Service
public class JobCategoryImpService implements JobCategoryService {

	 @Autowired
    private JobCategoryRepository jobCategoryRepository;

   
    @Override
    public JobCategory createJobCategory(JobCategory jobCategory) {

        return jobCategoryRepository.save(jobCategory);

    }

    @Override
    public List<JobCategory> getAllJobCategories() {

        return jobCategoryRepository.findAll();

    }

    @Override
    public JobCategory updateJobCategory(int id, JobCategory jobCategory) {
        JobCategory dbJobCategory = isJobCategoryExist(id);

        dbJobCategory.setTitle(jobCategory.getTitle());
        dbJobCategory.setDescription(jobCategory.getDescription());

        return jobCategoryRepository.save(dbJobCategory);
    }

    @Override
    public String deleteJobCategoryById(int id) {


        JobCategory dbJobCategory = isJobCategoryExist(id);

        jobCategoryRepository.delete(dbJobCategory);

        return "Job Category Deleted Successfully";
    }


    private JobCategory isJobCategoryExist(int id) {
        JobCategory dbJobCategory = jobCategoryRepository.findById(id).orElse(null);

        return dbJobCategory;
    }

}


