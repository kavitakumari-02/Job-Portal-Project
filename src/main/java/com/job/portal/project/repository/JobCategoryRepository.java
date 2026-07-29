package com.job.portal.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.project.entity.JobCategory;
@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer> {

    Optional<JobCategory> findByTitle(String title);

}
