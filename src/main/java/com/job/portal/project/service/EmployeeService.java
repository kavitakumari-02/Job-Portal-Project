package com.job.portal.project.service;

import java.util.List;

import com.job.portal.project.dto.EmployeeDto;
import com.job.portal.project.entity.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(int employeeId);

}
