package guru.springframework.multipledatasources.dao.leaftech;

import guru.springframework.multipledatasources.model.leaftech.Genomic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenomicRepository extends JpaRepository<Genomic, String> {
}
