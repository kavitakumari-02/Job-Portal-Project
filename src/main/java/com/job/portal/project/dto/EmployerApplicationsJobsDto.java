package com.job.portal.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class EmployerApplicationsJobsDto {

    private String companyName;
    private String companyLogo;
    private String jobTitle;
    private String jobCategory;
    private String type;
    private String employeeName;
    private String location;
    private int applicationId;
    private String status;
	public EmployerApplicationsJobsDto(String companyName, String companyLogo, String jobTitle, String jobCategory,
			String type, String employeeName, String location, int applicationId, String status) {
		super();
		this.companyName = companyName;
		companyLogo = companyLogo;
		this.jobTitle = jobTitle;
		this.jobCategory = jobCategory;
		this.type = type;
		this.employeeName = employeeName;
		this.location = location;
		this.applicationId = applicationId;
		this.status = status;
	}
   
}
