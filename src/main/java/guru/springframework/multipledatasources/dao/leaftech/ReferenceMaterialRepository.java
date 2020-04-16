package guru.springframework.multipledatasources.dao.leaftech;

import guru.springframework.multipledatasources.model.leaftech.ReferenceMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceMaterialRepository extends JpaRepository<ReferenceMaterial, String> {
}
