package spring.data.jpa.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.data.jpa.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
