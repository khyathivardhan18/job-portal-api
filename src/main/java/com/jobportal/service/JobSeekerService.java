package com.jobportal.service;

import com.jobportal.model.JobSeeker;
import com.jobportal.repository.JobSeekerRepository;
import com.jobportal.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobSeekerService {
    private final JobSeekerRepository jobSeekerRepository;

    public JobSeekerService(JobSeekerRepository jobSeekerRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
    }

    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

    public JobSeeker getJobSeekerById(Long id) {
        return jobSeekerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobSeeker not found with id: " + id));
    }

    @Transactional
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        jobSeeker.setActive(true);
        jobSeeker.setRegistrationDate(java.time.LocalDateTime.now());
        return jobSeekerRepository.save(jobSeeker);
    }

    @Transactional
    public JobSeeker updateJobSeeker(Long id, JobSeeker jobSeekerDetails) {
        JobSeeker jobSeeker = jobSeekerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobSeeker not found with id: " + id));
        jobSeeker.setName(jobSeekerDetails.getName());
        jobSeeker.setEmail(jobSeekerDetails.getEmail());
        jobSeeker.setPhone(jobSeekerDetails.getPhone());
        jobSeeker.setResumeUrl(jobSeekerDetails.getResumeUrl());
        jobSeeker.setSkills(jobSeekerDetails.getSkills());
        jobSeeker.setExperience(jobSeekerDetails.getExperience());
        return jobSeekerRepository.save(jobSeeker);
    }
} 