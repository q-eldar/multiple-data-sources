package guru.springframework.multipledatasources.dao.inventory;

import guru.springframework.multipledatasources.model.inventory.Seed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeedRepository extends JpaRepository<Seed, String> {
}
