package spring.data.jpa.order.sql

class UserSql {
    public static final String SELECT_USER_WITH_ORDERS = """
                SELECT u.id as user_id, u.name as user_name, u.email as user_email, u.created_at as user_created_at,
                o.id as order_id, o.product_name, o.price, o.created_at as order_created_at
                FROM users u
                LEFT JOIN orders o ON u.id = o.user_id
                WHERE u.id = ?
                ORDER BY u.id
            """
}
