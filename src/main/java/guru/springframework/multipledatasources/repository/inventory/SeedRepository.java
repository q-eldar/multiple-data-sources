package guru.springframework.multipledatasources.repository.inventory;

import guru.springframework.multipledatasources.model.inventory.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedRepository extends JpaRepository<Seed, Long> {
}
