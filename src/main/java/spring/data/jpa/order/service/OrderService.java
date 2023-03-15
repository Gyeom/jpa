package spring.data.jpa.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.data.jpa.ResourceNotFoundException;
import spring.data.jpa.order.model.dto.OrderRetrieveResponse;
import spring.data.jpa.order.model.entity.Order;
import spring.data.jpa.order.model.dto.OrderCreateRequest;
import spring.data.jpa.order.repository.OrderRepository;
import spring.data.jpa.user.model.entity.User;
import spring.data.jpa.order.repository.OrderBulkRepository;
import spring.data.jpa.user.repository.UserRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final OrderBulkRepository orderBulkRepository;

    public void createOrder(final OrderCreateRequest orderCreateRequest,
                            final long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Order order = orderCreateRequest.toEntity(user);
        orderRepository.save(order);
    }

    public OrderRetrieveResponse findOrderInfo(final long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));

        return OrderRetrieveResponse.from(order);
    }

    // TEST
    public void saveOrders() {
        List<Order> orders = new ArrayList<>();
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", 1L));
        orders.add(new Order("사과", BigDecimal.ONE, user));
        orders.add(new Order("파인애플", BigDecimal.ONE, user));
        orders.add(new Order("바나나", BigDecimal.ONE, user));
        orders.add(new Order("복숭아", BigDecimal.ONE, user));
        orders.add(new Order("자두", BigDecimal.ONE, user));

        orderBulkRepository.saveAll(orders);
    }
}
