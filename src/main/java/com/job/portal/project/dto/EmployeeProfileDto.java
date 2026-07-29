package com.job.portal.project.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProfileDto {

    private int id;
    private MultipartFile photo;
    private String github;
    private String linkedin;
    private String bio;
    private String website;
    private MultipartFile resume;

}
