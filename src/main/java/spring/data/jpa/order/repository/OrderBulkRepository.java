package spring.data.jpa.order.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.data.jpa.order.model.Order;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderBulkRepository {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAll(List<Order> orders) {
        String sql = "INSERT INTO orders (product_name, price, created_at, user_id) VALUES (?, ?, ?, ?)";
        Date currentDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        jdbcTemplate.batchUpdate(sql,
                orders,
                orders.size(),
                (PreparedStatement ps, Order order) -> {
                    ps.setString(1, order.getProductName());
                    ps.setBigDecimal(2, order.getPrice());
                    ps.setDate(3, sqlDate);
                    ps.setLong(4, order.getUser().getId());
                });
    }
}
