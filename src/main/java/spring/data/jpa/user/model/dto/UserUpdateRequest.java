package spring.data.jpa.user.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;
import spring.data.jpa.user.model.entity.User;

@Getter
@NoArgsConstructor
public class UserUpdateRequest {

    private String name;
    private String email;

    public UserUpdateRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User toEntity() {
        return new User(this.name, this.email);
    }
}
