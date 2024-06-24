package vincenzo.caio.feefo_challenge.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import vincenzo.caio.feefo_challenge.dto.NormalizedJobDto;
import vincenzo.caio.feefo_challenge.model.Job;
import vincenzo.caio.feefo_challenge.repository.JobRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobServiceTest {

    @Autowired
    private JobService jobService;

    @Mock
    private JobRepository jobRepository;

    List<Job> jobs = List.of(
            new Job(null, "Architect"),
            new Job(null, "Software engineer"),
            new Job(null, "Accountant"),
            new Job(null, "Quantity surveyor")
    );

    @Test
    public void normalizeJob_shouldGetTitle_WhenCorrectInput() {
        Mockito.when(jobRepository.findAll()).thenReturn(jobs);
        NormalizedJobDto normalized = jobService.normalizeJob("Java engineer");
        Assertions.assertEquals(normalized.title(), "Software engineer");

        normalized = jobService.normalizeJob("Accountant");
        Assertions.assertEquals("Accountant", normalized.title());
        Assertions.assertEquals(0, normalized.distance());

        normalized = jobService.normalizeJob("Chief accountant");
        Assertions.assertEquals("Accountant", normalized.title());
    }

    @Test
    public void normalizeJob_shouldThrowError_WhenIncorrectInput() {
        Mockito.when(jobRepository.findAll()).thenReturn(jobs);
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobService.normalizeJob(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobService.normalizeJob(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> jobService.normalizeJob("    "));
    }

}