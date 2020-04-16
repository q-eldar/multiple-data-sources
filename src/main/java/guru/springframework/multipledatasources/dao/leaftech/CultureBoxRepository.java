package guru.springframework.multipledatasources.dao.leaftech;

import guru.springframework.multipledatasources.model.leaftech.CultureBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CultureBoxRepository extends JpaRepository<CultureBox, String> {
}
