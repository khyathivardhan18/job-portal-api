package com.jobportal.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Job is required")
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @NotNull(message = "Job seeker is required")
    @ManyToOne
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeeker jobSeeker;

    @NotBlank(message = "Status is required")
    @Column(nullable = false)
    private String status; // APPLIED, INTERVIEWING, ACCEPTED, REJECTED

    @NotBlank(message = "Cover letter is required")
    private String coverLetter;

    @NotBlank(message = "Resume URL is required")
    private String resumeUrl;

    @NotNull(message = "Application date is required")
    @Column(nullable = false)
    private LocalDateTime applicationDate;

    private LocalDateTime lastUpdatedDate;

    // Default constructor
    public Application() {
    }

    // All-args constructor
    public Application(Long id, Job job, JobSeeker jobSeeker, String status,
                      String coverLetter, String resumeUrl, LocalDateTime applicationDate,
                      LocalDateTime lastUpdatedDate) {
        this.id = id;
        this.job = job;
        this.jobSeeker = jobSeeker;
        this.status = status;
        this.coverLetter = coverLetter;
        this.resumeUrl = resumeUrl;
        this.applicationDate = applicationDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
} 