package com.job.portal.project.impservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.project.entity.Employer;
import com.job.portal.project.repository.EmployerRepository;
import com.job.portal.project.service.EmployerService;
@Service
public class EmployerImpService implements EmployerService{
	
	@Autowired
	private EmployerRepository employerRepository;
	
	
	@Override
	public List<Employer> findAllEmployers() {
		return employerRepository.findAll();
	}

	@Override
	public Employer createEmployer(Employer employer) {
		 return employerRepository.save(employer);
	}

	
}
