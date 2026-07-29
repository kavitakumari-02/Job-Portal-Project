package com.job.portal.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.portal.project.dto.EmployerApplicationsJobsDto;
import com.job.portal.project.entity.JobApplication;
@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
	@Query("SELECT ja FROM JobApplication ja WHERE ja.employee.id = :employeeId")
	List<JobApplication> findAllApplicationByEmployeeId(@Param("employeeId") int employeeId);

	@Query("""
			SELECT new com.job.portal.project.dto.EmployerApplicationsJobsDto(
			    job.companyName,
			    job.logoPath,
			    job.title,
			    jc.title,
			    job.jobType,
			    CONCAT(e.firstName,' ',e.lastName),
			    CONCAT(job.city, ', ', job.country),
			    ja.id,
			    ja.status
			)
			FROM JobApplication ja
			JOIN ja.job job
			JOIN job.employer emp
			JOIN job.jobCategory jc
			JOIN ja.employee e
			WHERE emp.id=:employerId
			""")
	    List<EmployerApplicationsJobsDto> findAllApplicationForEmployer(
	            @Param("employerId") int employerId);


	@Query("""
			SELECT new com.job.portal.project.dto.EmployerApplicationsJobsDto(
			    job.companyName,
			    job.logoPath,
			    job.title,
			    jc.title,
			    job.jobType,
			    CONCAT(e.firstName,' ',e.lastName),
			    CONCAT(job.city, ', ', job.country),
			    ja.id,
			    ja.status
			)
			FROM JobApplication ja
			JOIN ja.job job
			JOIN job.employer emp
			JOIN job.jobCategory jc
			JOIN ja.employee e
			""")
	    List<EmployerApplicationsJobsDto> findAllApplication();
	}