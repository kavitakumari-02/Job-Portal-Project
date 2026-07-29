package com.job.portal.project.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationDto {

    private JobResponse jobResponse;
    private int applicationId;
    private String status;
    private LocalDateTime appliedDate;

}
