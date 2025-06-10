package com.jobportal.service;

import com.jobportal.exception.DuplicateResourceException;
import com.jobportal.exception.ResourceNotFoundException;
import com.jobportal.model.Application;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.JobSeekerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;
    private final JobSeekerRepository jobSeekerRepository;

    private static final List<String> VALID_STATUSES = Arrays.asList(
        "APPLIED", "UNDER_REVIEW", "SHORTLISTED", "REJECTED", "ACCEPTED"
    );

    public ApplicationService(ApplicationRepository applicationRepository,
                            JobRepository jobRepository,
                            JobSeekerRepository jobSeekerRepository) {
        this.applicationRepository = applicationRepository;
        this.jobRepository = jobRepository;
        this.jobSeekerRepository = jobSeekerRepository;
    }

    public List<Application> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    public List<Application> getApplicationsByJobSeekerId(Long jobSeekerId) {
        return applicationRepository.findByJobSeekerId(jobSeekerId);
    }

    @Transactional
    public Application createApplication(Application application) {
        // Validate job and job seeker exist
        jobRepository.findById(application.getJob().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + application.getJob().getId()));
        jobSeekerRepository.findById(application.getJobSeeker().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Job seeker not found with id: " + application.getJobSeeker().getId()));

        // Check if application already exists
        if (applicationRepository.existsByJobIdAndJobSeekerId(
                application.getJob().getId(),
                application.getJobSeeker().getId())) {
            throw new DuplicateResourceException("Application already exists for this job");
        }

        application.setApplicationDate(LocalDateTime.now());
        application.setLastUpdatedDate(LocalDateTime.now());
        application.setStatus("APPLIED");
        
        return applicationRepository.save(application);
    }

    @Transactional
    public Application updateApplicationStatus(Long id, String status) {
        if (!VALID_STATUSES.contains(status)) {
            throw new IllegalArgumentException("Invalid application status: " + status);
        }

        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
        
        application.setStatus(status);
        application.setLastUpdatedDate(LocalDateTime.now());
        
        return applicationRepository.save(application);
    }
} 