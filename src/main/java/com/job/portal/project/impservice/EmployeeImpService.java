package com.job.portal.project.impservice;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.project.dto.EmployeeDto;
import com.job.portal.project.entity.Employee;
import com.job.portal.project.entity.EmployeeRole;
import com.job.portal.project.repository.EmployeeRepository;
import com.job.portal.project.service.EmployeeService;
@Service
public class EmployeeImpService implements EmployeeService{

	@Autowired
	public EmployeeRepository employeeRepository;

	private ModelMapper modelMapper;
	EmployeeImpService(ModelMapper modelMapper){
	this.modelMapper=modelMapper;	
	}
	@Override
	public Employee createEmployee(Employee employee) {
		
		EmployeeRole employeeRole=new EmployeeRole();
		employeeRole.setName("Role_Employee");
		employeeRole.setEmployee(employee);
		employee.setRoles(Set.of(employeeRole));
		
		return employeeRepository.save(employee);
	}

	 @Override
	    public List<EmployeeDto> getAllEmployees() {

	        List<Employee> dbEmployeesList = employeeRepository.findAll();

	        return dbEmployeesList.stream().map((employee -> mapToDto(employee))).collect(Collectors.toList());

	    }
	
	 private EmployeeDto mapToDto(Employee employee) {
		 return modelMapper.map(employee,EmployeeDto.class);
	 }
	 
	 
	@Override
	public EmployeeDto getEmployeeById(int employeeId) {
		 Employee employee = employeeRepository.findById(employeeId).orElseThrow(null);
		
		return mapToDto(employee);
	}

}
