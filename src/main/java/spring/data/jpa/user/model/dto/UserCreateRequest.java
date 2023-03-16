package spring.data.jpa.user.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.data.jpa.user.model.entity.User;

@Getter
@NoArgsConstructor
public class UserCreateRequest {

    private String name;
    private String email;

    public UserCreateRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User toEntity() {
        return new User(this.name, this.email);
    }
}
