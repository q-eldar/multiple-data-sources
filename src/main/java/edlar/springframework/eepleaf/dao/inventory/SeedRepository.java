package edlar.springframework.eepleaf.dao.inventory;

import edlar.springframework.eepleaf.model.inventory.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedRepository extends JpaRepository<Seed, Long> {
}
