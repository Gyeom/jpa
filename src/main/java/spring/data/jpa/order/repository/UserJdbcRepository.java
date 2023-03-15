package spring.data.jpa.order.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spring.data.jpa.user.model.dto.UserOrderRetrieveResponse;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<UserOrderRetrieveResponse> findUserWithOrders(final Long userId) {
        String sql = "SELECT u.id as user_id, u.name as user_name, u.email as user_email, u.created_at as user_created_at, " +
                "o.id as order_id, o.product_name, o.price, o.created_at as order_created_at " +
                "FROM users u " +
                "LEFT JOIN orders o ON u.id = o.user_id " +
                "WHERE u.id = ?" +
                "ORDER BY u.id";

        RowMapper<UserOrderRetrieveResponse> rowMapper = (rs, rowNum) ->
                new UserOrderRetrieveResponse(
                        rs.getLong("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_email"),
                        rs.getTimestamp("user_created_at").toLocalDateTime(),
                        rs.getLong("order_id"),
                        rs.getString("product_name"),
                        rs.getDouble("price"),
                        rs.getTimestamp("order_created_at").toLocalDateTime()
                );

        return jdbcTemplate.query(sql, rowMapper, userId);
    }
}
