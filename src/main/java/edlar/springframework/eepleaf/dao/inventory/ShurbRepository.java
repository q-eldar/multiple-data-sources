package edlar.springframework.eepleaf.dao.inventory;

import edlar.springframework.eepleaf.model.inventory.Shrub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShurbRepository extends JpaRepository<Shrub, Long> {
}
