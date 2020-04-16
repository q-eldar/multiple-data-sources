package guru.springframework.multipledatasources.dao.leaftech;

import guru.springframework.multipledatasources.model.leaftech.Processing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessiongRepository extends JpaRepository<Processing, String> {
}
