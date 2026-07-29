package com.job.portal.project.service;

import java.io.IOException;

import com.job.portal.project.dto.EmployeeProfileDto;
import com.job.portal.project.dto.EmployeeProfileResponse;

public interface EmployeeProfileService {
	 EmployeeProfileResponse createEmployeeProfile(EmployeeProfileDto employeeProfileDto , int employeeId) throws IOException;

}
