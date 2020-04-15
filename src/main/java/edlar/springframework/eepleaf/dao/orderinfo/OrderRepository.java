package edlar.springframework.eepleaf.dao.orderinfo;

import edlar.springframework.eepleaf.model.orderinfo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
