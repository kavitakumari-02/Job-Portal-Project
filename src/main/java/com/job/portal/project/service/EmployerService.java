package com.job.portal.project.service;

import java.util.List;

import com.job.portal.project.entity.Employer;

public interface EmployerService {

    List<Employer> findAllEmployers();

    Employer createEmployer(Employer employer);
}
