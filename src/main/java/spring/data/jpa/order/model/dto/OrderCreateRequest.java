package spring.data.jpa.order.model.dto;

import lombok.Value;
import spring.data.jpa.order.model.entity.Order;
import spring.data.jpa.user.model.entity.User;

import java.math.BigDecimal;

@Value
public class OrderCreateRequest {

    String productName;
    BigDecimal price;

    public OrderCreateRequest(String productName, BigDecimal price) {
        this.productName = productName;
        this.price = price;
    }

    public Order toEntity(final User user) {
        return new Order(this.productName, this.price, user);
    }
}
