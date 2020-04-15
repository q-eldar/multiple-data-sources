package edlar.springframework.eepleaf.dao.leaftech;

import edlar.springframework.eepleaf.model.leaftech.Genomic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenomicRepository extends JpaRepository<Genomic, Long> {
}
