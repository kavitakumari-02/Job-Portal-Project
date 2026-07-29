package com.job.portal.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {

    private int jobId;
    private String title;
    private String companyName;
    private String jobDescription;
    private String skills;
    private String jobType;
    private String salaryRange;
    private String experience;
    private String street;
    private String city;
    private String pinCode;
    private String country;
    private String  companyLogo;
    private String jobCategory;
    private int employerId;

}
