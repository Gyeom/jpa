package spring.data.jpa.user.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class UserOrderRetrieveResponse {

    Long userId;
    String userName;
    String userEmail;
    LocalDateTime userCreatedAt;
    Long orderId;
    String productName;
    Double price;
    LocalDateTime orderCreatedAt;
}
