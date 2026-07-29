package com.job.portal.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.job.portal.project.dto.JobResponse;
import com.job.portal.project.entity.Employee;
import com.job.portal.project.entity.EmployeeSkill;

@SpringBootApplication
@EnableJpaAuditing
public class ECommerceProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceProject1Application.class, args);
		//Employee employee=new Employee();

	}

}
