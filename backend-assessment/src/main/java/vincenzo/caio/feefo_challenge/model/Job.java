package vincenzo.caio.feefo_challenge.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import vincenzo.caio.feefo_challenge.dto.JobDto;

import java.util.UUID;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String title;

    public Job() {
    }

    public Job(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static JobDto toDto(Job job) {
        return new JobDto(job.getId(), job.getTitle());
    }
}
