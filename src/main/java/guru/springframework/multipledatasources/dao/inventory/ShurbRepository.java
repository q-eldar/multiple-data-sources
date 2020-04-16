package guru.springframework.multipledatasources.dao.inventory;

import guru.springframework.multipledatasources.model.inventory.Shrub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShurbRepository extends JpaRepository<Shrub, String> {
}
