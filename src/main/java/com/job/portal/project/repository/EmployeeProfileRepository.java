package com.job.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.project.entity.EmployeeProfile;
@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile , Integer>{

}
