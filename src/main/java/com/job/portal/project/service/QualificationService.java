package com.job.portal.project.service;

import com.job.portal.project.dto.QualificationDto;

public interface QualificationService {

	QualificationDto createQualification(QualificationDto qualification , int employeeId);
}
