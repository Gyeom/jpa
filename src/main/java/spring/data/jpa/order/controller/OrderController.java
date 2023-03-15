package spring.data.jpa.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.data.jpa.order.entity.OrderRetrieveResponse;
import spring.data.jpa.order.model.OrderCreateRequest;
import spring.data.jpa.order.service.OrderService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public OrderRetrieveResponse findOrderInfo(@PathVariable long orderId) {
        return orderService.findOrderInfo(orderId);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Void> createOrder(
            @PathVariable long userId,
            @RequestBody OrderCreateRequest orderCreateRequest) {
        orderService.createOrder(orderCreateRequest, userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/test/bulk/insert")
    public ResponseEntity<Void> saveOrders() {
        orderService.saveOrders();
        return ResponseEntity.ok().build();
    }
}
