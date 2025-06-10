package com.jobportal.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description can't be longer than 1000 characters")
    @Column(length = 1000)
    private String description;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Company is required")
    private String company;

    @NotBlank(message = "Salary is required")
    private String salary;

    @NotBlank(message = "Job type is required")
    private String jobType; // FULL_TIME, PART_TIME, CONTRACT

    @NotNull(message = "Post date is required")
    @Column(nullable = false)
    private LocalDateTime postDate;

    private LocalDateTime expiryDate;

    @Column(nullable = false)
    private boolean active = true;

    // Default constructor
    public Job() {
    }

    // All-args constructor
    public Job(Long id, String title, String description, String location, String company,
              String salary, String jobType, LocalDateTime postDate, LocalDateTime expiryDate,
              boolean active) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.company = company;
        this.salary = salary;
        this.jobType = jobType;
        this.postDate = postDate;
        this.expiryDate = expiryDate;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
} 