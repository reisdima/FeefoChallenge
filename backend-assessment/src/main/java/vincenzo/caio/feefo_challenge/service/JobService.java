package vincenzo.caio.feefo_challenge.service;

import ch.qos.logback.core.util.StringUtil;
import org.springframework.stereotype.Service;
import vincenzo.caio.feefo_challenge.dto.JobDto;
import vincenzo.caio.feefo_challenge.dto.NormalizedJobDto;
import vincenzo.caio.feefo_challenge.model.Job;
import vincenzo.caio.feefo_challenge.repository.JobRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job addNewJob(JobDto jobDto) {
        Job job = new Job();
        job.setTitle(jobDto.title());
        return jobRepository.save(job);
    }

    public NormalizedJobDto normalizeJob(String input) {
        return this.getBestMatchForNormalization(input);
    }


    private NormalizedJobDto getBestMatchForNormalization(String input) {
        if(input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("Input should not be empty");
        }
        List<Job> normalizedJobTitles = jobRepository.findAll();
        Optional<NormalizedJobDto> bestMatch = normalizedJobTitles.stream()
                .map(job -> new NormalizedJobDto(job.getTitle(), levenshteinDistance(input.trim().toLowerCase(), job.getTitle().toLowerCase())))
                .min(Comparator.comparingInt(NormalizedJobDto::distance));
        return bestMatch.orElse(null);
    }

    private int levenshteinDistance(String s1, String s2) {
        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    costs[j] = j;
                } else if (j > 0) {
                    int newValue = costs[j - 1];
                    if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                        newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                    }
                    costs[j - 1] = lastValue;
                    lastValue = newValue;
                }
            }
            if (i > 0) {
                costs[s2.length()] = lastValue;
            }
        }
        return costs[s2.length()];
    }
}
