package com.jobportal.model;

import javax.persistence.*;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "job_seekers")
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotBlank(message = "Resume URL is required")
    private String resumeUrl;

    @NotBlank(message = "Skills are required")
    private String skills;

    @NotBlank(message = "Experience is required")
    private String experience;

    @NotNull(message = "Registration date is required")
    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    private boolean active = true;

    // Default constructor
    public JobSeeker() {
    }

    // All-args constructor
    public JobSeeker(Long id, String name, String email, String phone, String resumeUrl,
                    String skills, String experience, LocalDateTime registrationDate,
                    boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.resumeUrl = resumeUrl;
        this.skills = skills;
        this.experience = experience;
        this.registrationDate = registrationDate;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
} 