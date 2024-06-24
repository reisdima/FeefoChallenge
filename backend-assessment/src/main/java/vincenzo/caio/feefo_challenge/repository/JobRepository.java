package vincenzo.caio.feefo_challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vincenzo.caio.feefo_challenge.model.Job;

import java.util.UUID;

public interface JobRepository extends JpaRepository<Job, UUID> {
}
