package guru.springframework.multipledatasources.dao.leaftech;

import guru.springframework.multipledatasources.model.leaftech.CultureBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CultureBoxRepsitory extends JpaRepository<CultureBox, String> {
}
