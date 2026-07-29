package com.job.portal.project.service;

import com.job.portal.project.dto.WorkExperienceDto;

public interface WorkExperienceService {
	 WorkExperienceDto createWorkExperience(WorkExperienceDto workExperienceDto, int employeeId);
}
