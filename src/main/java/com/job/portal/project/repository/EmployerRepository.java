package com.job.portal.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.project.entity.Employer;
@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

    Optional<Employer> findByEmail(String email);


}
