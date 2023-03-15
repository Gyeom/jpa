package spring.data.jpa.user.model.dto;

import lombok.Value;
import spring.data.jpa.user.model.entity.User;

@Value
public class UserCreateRequest {

    String name;
    String email;

    public UserCreateRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User toEntity() {
        return new User(this.name, this.email);
    }
}
