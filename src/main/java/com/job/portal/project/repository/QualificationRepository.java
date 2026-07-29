package com.job.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.project.entity.Qualification;
@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Integer>{

}
