package spring.data.jpa.order.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spring.data.jpa.user.model.dto.UserOrderRetrieveResponse;

import java.util.List;

import static spring.data.jpa.order.sql.UserSql.SELECT_USER_WITH_ORDERS;

@Repository
@RequiredArgsConstructor
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<UserOrderRetrieveResponse> findUserWithOrders(final Long userId) {
        RowMapper<UserOrderRetrieveResponse> rowMapper = createUserOrderRowMapper();
        return jdbcTemplate.query(SELECT_USER_WITH_ORDERS, rowMapper, userId);
    }

    private RowMapper<UserOrderRetrieveResponse> createUserOrderRowMapper() {
        return (rs, rowNum) ->
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
    }
}
