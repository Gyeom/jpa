package spring.data.jpa.fixture;

import spring.data.jpa.order.model.dto.OrderCreateRequest;
import spring.data.jpa.user.model.dto.UserCreateRequest;
import spring.data.jpa.user.model.dto.UserUpdateRequest;

import java.math.BigDecimal;

public class Fixture {

    public static UserCreateRequest createUserCreateRequest(final String name, final String email) {
        return new UserCreateRequest(name, email);
    }

    public static UserUpdateRequest createUserUpdateRequest(final String name, final String email) {
        return new UserUpdateRequest(name, email);
    }
}
