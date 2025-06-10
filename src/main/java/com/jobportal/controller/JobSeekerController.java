package com.jobportal.controller;

import com.jobportal.model.JobSeeker;
import com.jobportal.service.JobSeekerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
    private final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping
    public ResponseEntity<JobSeeker> createJobSeeker(@Valid @RequestBody JobSeeker jobSeeker) {
        return ResponseEntity.ok(jobSeekerService.createJobSeeker(jobSeeker));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobSeeker> updateJobSeeker(@PathVariable Long id, @Valid @RequestBody JobSeeker jobSeeker) {
        return ResponseEntity.ok(jobSeekerService.updateJobSeeker(id, jobSeeker));
    }

    @GetMapping
    public ResponseEntity<List<JobSeeker>> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers();
        if (jobSeekers == null || jobSeekers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jobSeekers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable Long id) {
        JobSeeker jobSeeker = jobSeekerService.getJobSeekerById(id);
        if (jobSeeker == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jobSeeker);
    }
}
