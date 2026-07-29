package com.job.portal.project.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDto {

    private Integer id;
    private String company;
    private String position;
    private Date startDate;
    private Date endDate;


}
