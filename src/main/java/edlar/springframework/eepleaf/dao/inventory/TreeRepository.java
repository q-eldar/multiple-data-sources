package edlar.springframework.eepleaf.dao.inventory;

import edlar.springframework.eepleaf.model.inventory.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<Tree, Long> {
}
