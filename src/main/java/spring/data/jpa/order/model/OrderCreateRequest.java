package spring.data.jpa.order.model;

import lombok.Getter;
import spring.data.jpa.user.model.User;

import java.math.BigDecimal;

@Getter
public class OrderCreateRequest {

    private final String productName;
    private final BigDecimal price;

    public OrderCreateRequest(String productName, BigDecimal price) {
        this.productName = productName;
        this.price = price;
    }

    public Order toEntity(final User user) {
        return new Order(this.productName, this.price, user);
    }
}
