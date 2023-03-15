package spring.data.jpa.user.model;

import lombok.Getter;
import spring.data.jpa.order.model.Order;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "email", nullable = false))
    })
    private Email email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private final List<Order> orders = new ArrayList<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public User(String name, String email) {
        this.name = name;
        this.email = new Email(email);
        this.createdAt = LocalDateTime.now();
    }

    protected User() {

    }

    public String getEmail() {
        return this.email.value();
    }
}