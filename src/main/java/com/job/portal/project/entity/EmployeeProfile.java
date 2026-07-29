package com.job.portal.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "photo_path")
    private String photoPath;
    @Column(name = "github")
    private String github;
    @Column(name = "linkedin")
    private String linkedin;
    @Column(name = "bio")
    private String bio;
    @Column(name = "website")
    private String website;
    @Column(name = "resume_path")
    private String resumePath;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
