package com.job.portal.project.service;

import com.job.portal.project.dto.EmployeeSkillDto;

public interface EmployeeSkillService {
	 EmployeeSkillDto createSkill(EmployeeSkillDto employeeSkillDto, int employeeId);
}
