package vincenzo.caio.feefo_challenge.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vincenzo.caio.feefo_challenge.dto.JobDto;
import vincenzo.caio.feefo_challenge.dto.NormalizedJobDto;
import vincenzo.caio.feefo_challenge.model.Job;
import vincenzo.caio.feefo_challenge.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> getJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.status(HttpStatus.OK).body(
                jobs.stream().map(Job::toDto).toList()
        );
    }

    @PostMapping
    public ResponseEntity<JobDto> addJob (@RequestBody JobDto jobDto) {
        Job newJob = jobService.addNewJob(jobDto);
        return ResponseEntity.status(HttpStatus.OK).body(Job.toDto(newJob));
    }

    @GetMapping("/normalize")
    public ResponseEntity<NormalizedJobDto> normlizeInputToJob(@RequestParam String input) {
        if(input == null || input.isEmpty() || input.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        NormalizedJobDto normalizedJobDto = jobService.normalizeJob(input);
        return ResponseEntity.status(HttpStatus.OK).body(normalizedJobDto);
    }
}
