package com.job.portal.project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.project.dto.EmployeeDto;
import com.job.portal.project.dto.EmployeeProfileDto;
import com.job.portal.project.dto.EmployeeProfileResponse;
import com.job.portal.project.dto.EmployeeSkillDto;
import com.job.portal.project.dto.JobApplicationDto;
import com.job.portal.project.dto.QualificationDto;
import com.job.portal.project.dto.WorkExperienceDto;
import com.job.portal.project.entity.Employee;
import com.job.portal.project.entity.WorkExperience;
import com.job.portal.project.impservice.EmployeeImpService;
import com.job.portal.project.service.EmployeeProfileService;
import com.job.portal.project.service.EmployeeService;
import com.job.portal.project.service.EmployeeSkillService;
import com.job.portal.project.service.JobApplicationService;
import com.job.portal.project.service.QualificationService;
import com.job.portal.project.service.WorkExperienceService;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
@Autowired
	public EmployeeService employeeService;
@Autowired
public EmployeeSkillService employeeSkillService;
@Autowired
private WorkExperienceService workExperienceService;
@Autowired
private QualificationService qualificationService;
@Autowired
private JobApplicationService jobApplicationService;

//@Autowired
//private EmployeeProfileService employeeProfileService;



            //Add Employee//
@PostMapping
public ResponseEntity<Employee>createEmployee(@RequestBody Employee employee){
	

	return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
}


         // GET ALL EMPLOYEE //
@GetMapping
public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

    List<EmployeeDto> employees = employeeService.getAllEmployees();


    return new ResponseEntity<>(employees, HttpStatus.OK);
}


             // GET EMPLOYEE BY ID//
 @GetMapping("/{employeeId}")
public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("employeeId") int employeeId) {
    return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
}
 
       // ADD SKILL BY EMPLOYEE_ID//
@PostMapping(value = "/{employeeId}/skills", consumes = {"*/*"})
public ResponseEntity<EmployeeSkillDto>addSkillDetails(@RequestBody EmployeeSkillDto employeeSkillDto,
                  @PathVariable("employeeId") int employeeId
) throws IOException {
 return new ResponseEntity<>(employeeSkillService.createSkill(employeeSkillDto, employeeId)
            , HttpStatus.CREATED);
}


            // ADD WORKEXPERIENCES BY //
@PostMapping("/{employeeId}/workExperiences")
public ResponseEntity<WorkExperienceDto> addWorkExperience(@RequestBody WorkExperienceDto workExperience
        , @PathVariable("employeeId") int employeeId
) {

    return new ResponseEntity<>(workExperienceService.createWorkExperience(workExperience, employeeId), HttpStatus.CREATED);
}


        // ADD QUALIFICATION BY EMPLOYEE_ID//

@PostMapping("/{employeeId}/qualifications")
public ResponseEntity<QualificationDto> addQualification(@RequestBody QualificationDto qualification
        , @PathVariable("employeeId") int employeeId) {

    return new ResponseEntity<>(qualificationService.createQualification(qualification, employeeId), HttpStatus.CREATED);
}




//@PostMapping(value = "/{employeeId}/profileDetails", consumes = {"*/*"})
//public ResponseEntity<EmployeeProfileResponse>
//addProfileDetails(@ModelAttribute EmployeeProfileDto employeeProfileDto,
//                  @PathVariable("employeeId") int employeeId
//) throws IOException {
//
//    return new ResponseEntity<>(employeeProfileService.createEmployeeProfile(employeeProfileDto, employeeId)
//            , HttpStatus.CREATED);
//
//}
//

@PostMapping("/{employeeId}/jobs/{jobId}/apply")
public ResponseEntity<String> applyForJob(@PathVariable("employeeId") int employeeId,
                                          @PathVariable("jobId") int jobId) {

    return new ResponseEntity<>(jobApplicationService.applyJob(employeeId, jobId), HttpStatus.CREATED);

}



@PostMapping("/{employeeId}/jobs/{jobId}/yourApplications/{applicationId}/cancel")
public ResponseEntity<String> cancelJobApplication(@PathVariable("employeeId") int employeeId,
                                                   @PathVariable("jobId") int jobId,
                                                   @PathVariable("applicationId") int applicationId) {

    return ResponseEntity.ok(jobApplicationService.cancelApplication(employeeId, jobId , applicationId));

}



@GetMapping("/{employeeId}/jobs/yourApplications")
public ResponseEntity<List<JobApplicationDto>> getAllJobApplicationByEmployee(
        @PathVariable("employeeId") int employeeId) {
    return ResponseEntity.ok(jobApplicationService.getAllApplicationsByEmployee(employeeId));
}

}
