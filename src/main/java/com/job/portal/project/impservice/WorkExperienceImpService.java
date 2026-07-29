package com.job.portal.project.impservice;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.project.dto.WorkExperienceDto;
import com.job.portal.project.entity.Employee;
import com.job.portal.project.entity.WorkExperience;
import com.job.portal.project.repository.EmployeeRepository;
import com.job.portal.project.repository.WorkExperienceReository;
import com.job.portal.project.service.WorkExperienceService;
@Service
public class WorkExperienceImpService implements WorkExperienceService{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
    private WorkExperienceReository workExperienceRepository;
	@Autowired
    private ModelMapper modelMapper;
	@Override
	public WorkExperienceDto createWorkExperience(WorkExperienceDto workExperienceDto, int employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).orElse(null);

		WorkExperience workExperience = mapToEntity(workExperienceDto);
        workExperience.setEmployee(employee);

        WorkExperience savedWorkExperience = workExperienceRepository.save(workExperience);

        return mapToDto(savedWorkExperience);

    }


    private WorkExperience mapToEntity(WorkExperienceDto workExperienceDto) {

        return modelMapper.map(workExperienceDto, WorkExperience.class);
    }

    private WorkExperienceDto mapToDto(WorkExperience workExperience) {
        return modelMapper.map(workExperience, WorkExperienceDto.class);
    }


}
