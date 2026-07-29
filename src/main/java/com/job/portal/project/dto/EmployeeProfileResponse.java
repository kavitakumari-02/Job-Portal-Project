package com.job.portal.project.dto;

import java.nio.file.Paths;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProfileResponse {
    private int id;
    private String photoPath;
    private String github;
    private String linkedin;
    private String bio;
    private String website;
    private String resumePath;


    public String getPhotoPath() {

        return Paths.get(photoPath).getFileName().toString();
    }

    public String getResumePath() {

        return Paths.get(resumePath).getFileName().toString();
    }}
