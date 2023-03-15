package spring.data.jpa.user.model;

import lombok.Value;

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
