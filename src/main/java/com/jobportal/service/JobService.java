package com.jobportal.service;

import com.jobportal.exception.ResourceNotFoundException;
import com.jobportal.model.Job;
import com.jobportal.repository.JobRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllActiveJobs() {
        return jobRepository.findByActiveTrue();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
    }

    public List<Job> searchJobs(String title, String location) {
        if (title != null && location != null) {
            return jobRepository.findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCase(title, location);
        } else if (title != null) {
            return jobRepository.findByTitleContainingIgnoreCase(title);
        } else if (location != null) {
            return jobRepository.findByLocationContainingIgnoreCase(location);
        }
        return getAllActiveJobs();
    }

    @Transactional
    public Job createJob(Job job) {
        job.setPostDate(LocalDateTime.now());
        job.setActive(true);
        return jobRepository.save(job);
    }

    @Transactional
    public Job updateJob(Long id, Job jobDetails) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
        
        job.setTitle(jobDetails.getTitle());
        job.setDescription(jobDetails.getDescription());
        job.setLocation(jobDetails.getLocation());
        job.setCompany(jobDetails.getCompany());
        job.setSalary(jobDetails.getSalary());
        job.setJobType(jobDetails.getJobType());
        job.setExpiryDate(jobDetails.getExpiryDate());
        
        return jobRepository.save(job);
    }

    @Transactional
    public void deleteJob(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
        job.setActive(false);
        jobRepository.save(job);
    }
} 