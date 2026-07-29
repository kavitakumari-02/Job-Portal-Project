package com.job.portal.project.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "skills")
    private String skills;
    @Column(name = "job_type")
    private String jobType;
    @Column(name = "salary_range")
    private String salaryRange;
    @Column(name = "experience")
    private String experience;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "pin_code")
    private String pinCode;
    @Column(name = "country")
    private String country;
    @Column(name = "logo_path")
    private String logoPath;
    
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private Employer employer;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jobcategory_id")
    private JobCategory jobCategory;
}
