package guru.springframework.multipledatasources.dao.orderinfo;

import guru.springframework.multipledatasources.model.orderinfo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
