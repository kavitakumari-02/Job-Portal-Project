package com.job.portal.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.job.portal.project.dto.JobResponse;
import com.job.portal.project.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{
	@Query("""
	        SELECT new com.job.portal.project.dto.JobResponse(
	            j.id,
	            j.title,
	            j.companyName,
	            j.jobDescription,
	            j.skills,
	            j.jobType,
	            j.salaryRange,
	            j.experience,
	            j.street,
	            j.city,
	            j.pinCode,
	            j.country,
	            j.logoPath,
	            j.jobCategory.title,
	            e.id
	        )
	        FROM Job j
	        JOIN j.employer e
	        """)
	 List<JobResponse> findByAllJobs();
	
	 @Query("""
		        SELECT new com.job.portal.project.dto.JobResponse(
		            j.id,
		            j.title,
		            j.companyName,
		            j.jobDescription,
		            j.skills,
		            j.jobType,
		            j.salaryRange,
		            j.experience,
		            j.street,
		            j.city,
		            j.pinCode,
		            j.country,
		            j.logoPath,
		            j.jobCategory.title,
		            e.id
		        )
		        FROM Job j
		        JOIN j.employer e
		        WHERE e.id = :employerId
		        """)
		     	 List<JobResponse> findByAllJobsByEmployerId(@Param("employerId") int employerId);
	 @Query("SELECT j FROM Job j WHERE j.employer.id=:employerId")
	 List<Job>test(@Param("employerId")int employerId);
	 @Query("""
		        SELECT new com.job.portal.project.dto.JobResponse(
		            j.id,
		            j.title,
		            j.companyName,
		            j.jobDescription,
		            j.skills,
		            j.jobType,
		            j.salaryRange,
		            j.experience,
		            j.street,
		            j.city,
		            j.pinCode,
		            j.country,
		            j.logoPath,
		            j.jobCategory.title,
		            e.id
		        )
		        FROM Job j
		        JOIN j.employer e
		        WHERE (:jobCategory IS NULL 
		               OR j.jobCategory.title = :jobCategory)
		        AND (:jobType IS NULL 
		               OR j.jobType = :jobType)
		        AND (:country IS NULL 
		               OR j.country = :country)
		        """)
	 List<JobResponse> searchJobs(@Param("jobCategory") String jobCategory, @Param("jobType") String jobType, @Param("country") String country);


}
