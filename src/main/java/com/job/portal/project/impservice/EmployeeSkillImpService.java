package com.job.portal.project.impservice;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.project.dto.EmployeeSkillDto;
import com.job.portal.project.entity.Employee;
import com.job.portal.project.entity.EmployeeSkill;
import com.job.portal.project.repository.EmployeeRepository;
import com.job.portal.project.repository.EmployeeSkillRepository;
import com.job.portal.project.service.EmployeeSkillService;
@Service
public class EmployeeSkillImpService implements  EmployeeSkillService{
	@Autowired
	 private EmployeeSkillRepository employeeSkillRepository;
	 @Autowired
	    private EmployeeRepository employeeRepository;
	 @Autowired
	    private ModelMapper modelMapper;
	    
	@Override
	public EmployeeSkillDto createSkill(EmployeeSkillDto employeeSkillDto, int employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow();

        EmployeeSkill employeeSkill = mapToEntity(employeeSkillDto);
        employeeSkill.setEmployee(employee);
        EmployeeSkill db = employeeSkillRepository.save(employeeSkill);
        return mapToDto(db);
    }


    private EmployeeSkillDto mapToDto(EmployeeSkill employeeSkill) {

        return modelMapper.map(employeeSkill, EmployeeSkillDto.class);
    }

    private EmployeeSkill mapToEntity(EmployeeSkillDto employeeSkillDto) {

        return modelMapper.map(employeeSkillDto, EmployeeSkill.class);
    }

	
}
