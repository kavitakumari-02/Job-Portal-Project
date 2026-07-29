package com.job.portal.project.impservice;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.project.dto.QualificationDto;
import com.job.portal.project.entity.Employee;
import com.job.portal.project.entity.Qualification;
import com.job.portal.project.repository.EmployeeRepository;
import com.job.portal.project.repository.QualificationRepository;
import com.job.portal.project.service.QualificationService;
@Service
public class QualificationImpservice implements QualificationService{

	@Autowired
    private QualificationRepository qualificationRepository;
	@Autowired
    private ModelMapper modelMapper;
	@Autowired
    private EmployeeRepository employeeRepository;


	
		@Override
	    public QualificationDto createQualification(QualificationDto qualificationDto, int employeeId) {

	        Employee employee = employeeRepository.findById(employeeId).orElse(null);
	      

	        // Set
	        Qualification qualification = mapToQualification(qualificationDto);
	        qualification.setEmployee(employee);
	        // insert
	        Qualification savedQualification = qualificationRepository.save(qualification);
	        return mapToQualificationDto(savedQualification);
	    }

	    private Qualification mapToQualification(QualificationDto qualificationDto) {

	        return modelMapper.map(qualificationDto, Qualification.class);
	    }

	    private QualificationDto mapToQualificationDto(Qualification qualification) {
	        return modelMapper.map(qualification, QualificationDto.class);
	    }


	
	
}
