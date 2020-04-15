package guru.springframework.multipledatasources.repository.inventory;

import guru.springframework.multipledatasources.model.inventory.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<Tree, Long> {
}
