package spring.data.jpa.user.model;

import lombok.Value;
import spring.data.jpa.order.entity.OrderRetrieveResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class UserRetrieveResponse {

    Long id;
    String name;
    String email;
    LocalDateTime createdAt;
    List<OrderRetrieveResponse> orderResponses;

    public static UserRetrieveResponse from(User user) {
        List<OrderRetrieveResponse> orderResponses = user.getOrders().stream()
                .map(OrderRetrieveResponse::from)
                .collect(Collectors.toList());
        return new UserRetrieveResponse(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt(), orderResponses);
    }
}
