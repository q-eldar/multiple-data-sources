package guru.springframework.multipledatasources.dao.inventory;

import guru.springframework.multipledatasources.model.inventory.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<Tree, String> {
}
