package spring.data.jpa.order.model.entity;

import lombok.Getter;
import spring.data.jpa.user.model.entity.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    protected Order() {
    }

    public Order(final String productName, final BigDecimal price, final User user) {
        this.productName = productName;
        this.price = price;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }
}
