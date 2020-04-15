package guru.springframework.multipledatasources.repository.orderinfo;

import guru.springframework.multipledatasources.model.orderinfo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
