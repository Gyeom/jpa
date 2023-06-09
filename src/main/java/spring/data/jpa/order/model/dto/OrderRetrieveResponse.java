package spring.data.jpa.order.model.dto;

import lombok.Value;
import spring.data.jpa.order.model.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class OrderRetrieveResponse {

    Long id;
    String productName;
    BigDecimal price;
    LocalDateTime createdAt;

    public static OrderRetrieveResponse from(final Order order) {
        return new OrderRetrieveResponse(order.getId(), order.getProductName(), order.getPrice(), order.getCreatedAt());
    }
}
