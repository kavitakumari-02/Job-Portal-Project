package com.job.portal.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.project.entity.EmployeeSkill;
@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Integer>{

}
